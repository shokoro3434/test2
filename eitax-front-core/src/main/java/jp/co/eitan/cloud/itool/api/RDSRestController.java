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

import com.eitax.recall.front.service.RDSService;

import jp.co.eitan.cloud.itool.api.model.SharedMapRequest;

@RestController
@RequestMapping("v1")
public class RDSRestController {
	@Autowired
	private RDSService rdsService;

	@RequestMapping(value = "/api/rds/instances", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Map<String, String> describeRDSInstances(SharedMapRequest dir, Model model) {
		return rdsService.describeInstances(dir.getAwsName(), dir.getRegion());
	}
	@RequestMapping(value = "/api/rds/snapshots", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Map<String, String> describeRDSSnapshots(SharedMapRequest dir, Model model) {
		return rdsService.describeSnapshots(dir.getAwsName(), dir.getRegion());
	}

}
