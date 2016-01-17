package jp.co.eitan.cloud.itool.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eitax.recall.front.domain.Lambda;
import com.eitax.recall.front.domain.LambdaJson;
import com.eitax.recall.front.domain.Profile;
import com.eitax.recall.front.service.AWSMasterDataService;
import com.eitax.recall.front.service.LambdaService;
import com.eitax.recall.front.service.ProfileService;
import com.eitax.recall.front.service.impl.LoginUserDetails;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.eitan.cloud.itool.api.model.ApiProfile;
import jp.co.eitan.cloud.itool.api.model.CreateLambdaJsonRequest;
import jp.co.eitan.cloud.itool.api.model.LambdaExecJsonRequest;
import jp.co.eitan.cloud.itool.api.model.LambdaScheduleRequest;
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
	@Autowired
	private AWSMasterDataService awsMasterDataService;

	@RequestMapping(value = "/api/lambda/schedules", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Map<String, String> requestSchedule(@AuthenticationPrincipal LoginUserDetails userDetails,
			LambdaScheduleRequest json, Model model) {
		ObjectMapper mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
		Profile p = profileService.findOne(userDetails.getUsername());
		try {
			return lambdaService.requestSchedule(p.getAccessKey(), p.getSecretKey(), p.getEmail(),
					mapper.writeValueAsString(json));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/api/lambda", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<Lambda> list(@AuthenticationPrincipal LoginUserDetails userDetails, Model model) {
		Profile profiile = profileService.findOne(userDetails.getUsername());
		List<Lambda> lambdaList = lambdaService.retrieveLambda(profiile);
		model.addAttribute("lambdaList", lambdaList);
		return lambdaList;
	}

	@RequestMapping(value = "/api/lambda/jobIds", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Map<String, String> retrieveJobList(@AuthenticationPrincipal LoginUserDetails userDetails, Model model) {
		Profile profiile = profileService.findOne(userDetails.getUsername());
		return lambdaService.retrieveLambdaList(profiile);
	}

	@RequestMapping(value = "/api/invoke", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public String invoke(LambdaExecGetRequest ler, Model model) {
		ObjectMapper mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
		try {
			LambdaJson json = mapper.readValue(ler.getDescription(), LambdaJson.class);
//			String actionName = json.getActionName();
//			String handler = actionName.startsWith("rds-") ? lambdaSettings.getRdsHandler() : lambdaSettings.getEc2Handler();
			return lambdaService.invoke(apiProfile.getAccessKey(), apiProfile.getSecretKey(),
					"Ishii_Takahiro2@bp.ogis-ri.co.jp", ler.getArn(), ApiUtils.toPayload(ler.getDescription()));

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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

	@RequestMapping(value = "/api/lambda", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public String createLambda(@AuthenticationPrincipal LoginUserDetails userDetails,@Validated @RequestBody CreateLambdaJsonRequest json) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
		JsonNode root = awsMasterDataService.retrieveActionSysRel();
		String modalId = null;
		String modModalId = null;
		String rh = null;
		for (int i = 0 ; i < root.size() ; i ++){
			JsonNode node = root.get(i);
			String action = json.getDescription().getActionName();
			if (null != node.get(action)){
				try{
				    rh = node.get(action).get("rh").isNull() ? null : node.get(action).get("rh").asText();
				    modalId = node.get(action).get("modalId").asText();
				    modModalId = node.get(action).get("modModalId").asText();
				}catch(Exception e){}
			    break;
			}
		}
		json.getDescription().getSys().setModalId(modalId);
		json.getDescription().getSys().setModModalId(modModalId);
		json.getDescription().getSys().setRh(rh);
		lambdaService.create(apiProfile.getAccessKey(), apiProfile.getSecretKey(),
				mapper.writeValueAsString(json.getDescription()));
		return "{}";
	}
	@RequestMapping(value = "/api/lambda/{arn}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Map<String, String> deleteFunction(@AuthenticationPrincipal LoginUserDetails userDetails, @PathVariable String arn,Model model) {
		return lambdaService.delete(apiProfile.getAccessKey(), apiProfile.getSecretKey(), arn);
	}

	@RequestMapping(value = "/api/lambda", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Map<String, Object> modify(
			@Validated @RequestBody LambdaExecJsonRequest lj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
		lambdaService.update(apiProfile.getAccessKey(), apiProfile.getSecretKey(), lj.getArn(),
				mapper.writeValueAsString(lj.getDescription()));
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("ret", "OK");
		return ret;
	}
	@RequestMapping(value = "/api/lambda/sg", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Map<String, Object> addInboundRule(
			@Validated @RequestBody LambdaExecJsonRequest lj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
		lambdaService.update(apiProfile.getAccessKey(), apiProfile.getSecretKey(), lj.getArn(),
				mapper.writeValueAsString(lj.getDescription()));
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("ret", "OK");
		return ret;
	}
}
