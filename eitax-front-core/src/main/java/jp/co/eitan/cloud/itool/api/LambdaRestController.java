package jp.co.eitan.cloud.itool.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClient;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.services.lambda.model.UpdateFunctionConfigurationRequest;
import com.amazonaws.services.lambda.model.UpdateFunctionConfigurationResult;
import com.eitax.recall.front.domain.Lambda;
import com.eitax.recall.front.domain.Profile;
import com.eitax.recall.front.service.AWSMasterDataService;
import com.eitax.recall.front.service.LambdaService;
import com.eitax.recall.front.service.ProfileService;
import com.eitax.recall.front.service.impl.LoginUserDetails;
import com.eitax.recall.front.web.CustomerForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.eitan.cloud.itool.api.model.ApiProfile;
import jp.co.eitan.cloud.itool.api.model.LambdaExecJsonRequest;
import jp.co.eitan.cloud.itool.api.util.ApiUtils;
import jp.co.eitan.cloud.itool.api.model.LambdaExecGetRequest;

@RestController
@RequestMapping("v1")
public class LambdaRestController {
	@Autowired
	private ApiProfile apiProfile;
	@Autowired
	private LambdaService lambdaService;
	@Autowired
	private ProfileService profileService;

	@RequestMapping(value = "/api/lambda", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<Lambda> list(@AuthenticationPrincipal LoginUserDetails userDetails,Model model) {
        Profile profiile = profileService.findOne(userDetails.getUsername());
        List<Lambda> lambdaList = lambdaService.retrieveLambda(profiile);
        model.addAttribute("lambdaList", lambdaList);
		return lambdaList;
	}
	@RequestMapping(value = "/api/invoke", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public String invoke(LambdaExecGetRequest ler, Model model) {
		ClientConfiguration conf = new ClientConfiguration().withConnectionTimeout(350 * 1000)
				.withSocketTimeout(350 * 1000).withRequestTimeout(350 * 1000);

		AWSLambda client = new AWSLambdaClient(new BasicAWSCredentials(apiProfile.getAccessKey(), apiProfile.getSecretKey()), conf);
		client.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));
		InvokeResult ir = client.invoke(new InvokeRequest().withFunctionName(ler.getArn()).withPayload(ApiUtils.toPayload(ler.getDescription()))
				.withSdkClientExecutionTimeout(1000 * 300).withSdkRequestTimeout(1000 * 300));
		System.out.println(ir);
		String resp = new String(ir.getPayload().array());
		System.err.println(resp);
		return resp;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody String handleMethodArgumentNotValidException(MethodArgumentNotValidException errors) {
		StringBuilder msg = new StringBuilder();
		errors.getBindingResult().getAllErrors().forEach(error -> {
			msg.append(error.getDefaultMessage());
		});
		return msg.toString();
	}

	@RequestMapping(value = "/api/lambda", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Map<String, Object> modify(
			@Validated @RequestBody LambdaExecJsonRequest lj/*
													 * ,BindingResult
													 * bindingResult,Model
													 * model,HttpServletResponse
													 * response
													 */) {
		// if (bindingResult.hasErrors()) {
		////
		// StringBuilder msg = new StringBuilder();
		// List<ObjectError> errors = bindingResult.getAllErrors();
		// errors.forEach(error -> {
		// msg.append(error.getDefaultMessage());
		// });
		// System.out.println(msg);
		// Map<String,Object> ret = new HashMap<String,Object>();
		// ret.put("ret", msg);
		// response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		// return ret;
		// }

		System.out.println("###############" + lj);
		AWSLambda client = new AWSLambdaClient(
				new BasicAWSCredentials(this.apiProfile.getAccessKey(), this.apiProfile.getSecretKey()));
		client.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));
		try {
			UpdateFunctionConfigurationResult result = client
					.updateFunctionConfiguration(new UpdateFunctionConfigurationRequest()
							.withDescription(new ObjectMapper().writeValueAsString(lj.getDescription())).withFunctionName(lj.getArn()));
		} catch (AmazonServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AmazonClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("ret", "ok");
		return ret;
	}
}
