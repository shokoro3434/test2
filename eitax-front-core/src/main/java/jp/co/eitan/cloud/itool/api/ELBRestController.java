package jp.co.eitan.cloud.itool.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.eitax.recall.front.service.ELBService;
import org.springframework.web.bind.annotation.RestController;


import jp.co.eitan.cloud.itool.api.model.SharedMapRequest;

@RestController
@RequestMapping("v1")
public class ELBRestController {
	@Autowired
	private ELBService elbService;

	@RequestMapping(value = "/api/elb/elbs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Map<String, String> describeRDSInstances(SharedMapRequest dir, Model model) {
		return elbService.describeLoadBalancers(dir.getAwsName(), dir.getRegion());
	}

}
