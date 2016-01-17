package jp.co.eitan.cloud.itool.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eitax.recall.front.service.EBSService;

import jp.co.eitan.cloud.itool.api.model.SharedMapRequest;

@RestController
@RequestMapping("v1")
public class EBSRestController {
	@Autowired
	private EBSService ebselbService;

	@RequestMapping(value = "/api/ebs/volumes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Map<String, String> describeRDSInstances(SharedMapRequest dir, Model model) {
		return ebselbService.describeVolumes(dir.getAwsName(), dir.getRegion());
	}

}
