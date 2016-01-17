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

import com.eitax.recall.front.service.EC2Service;

import jp.co.eitan.cloud.itool.api.model.SharedMapRequest;

@RestController
@RequestMapping("v1")
public class EC2RestController {
	@Autowired
	private EC2Service ec2Service;

	@RequestMapping(value = "/api/ec2/instances", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Map<String, String> describeInstances(SharedMapRequest dir, Model model) {
		return ec2Service.describeInstances(dir.getAwsName(), dir.getRegion());
	}

	@RequestMapping(value = "/api/ec2/images", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Map<String, String> describeImages(SharedMapRequest dir, Model model) {
		return ec2Service.describeImages(dir.getAwsName(), dir.getRegion());
	}

	@RequestMapping(value = "/api/ec2/sg", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Map<String, String> describeSG(SharedMapRequest dsr, Model model) {
		return ec2Service.describeSG(dsr.getAwsName(), dsr.getRegion());
	}
	@RequestMapping(value = "/api/ec2/snapshots", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Map<String, String> describeSnapshots(SharedMapRequest dsr, Model model) {
		return ec2Service.describeSnapshots(dsr.getAwsName(), dsr.getRegion());
	}

}
