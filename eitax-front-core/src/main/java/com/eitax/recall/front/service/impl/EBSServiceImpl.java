package com.eitax.recall.front.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeVolumesResult;
import com.amazonaws.services.ec2.model.Volume;
import com.amazonaws.services.ec2.model.DescribeVolumesRequest;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.eitax.recall.front.domain.Profile;
import com.eitax.recall.front.service.EBSService;
import com.eitax.recall.front.service.ProfileService;

@Service
public class EBSServiceImpl implements EBSService {
	@Autowired
	private ProfileService profileService;

	@Override
	public Map<String, String> describeVolumes(String profileName, String region) {
		try {
			Profile p = profileService.findOne(profileName);
			AmazonEC2 client = null;
			if (System.getProperty("useProxy") != null) {
				ClientConfiguration conf = new ClientConfiguration().withProxyHost(System.getProperty("proxyHost"))
						.withProxyPort(Integer.valueOf(System.getProperty("proxyPort")))
						.withProxyUsername(System.getProperty("proxyUsername"))
						.withProxyPassword(System.getProperty("proxyPassword")).withConnectionTimeout(350 * 1000)
						.withSocketTimeout(350 * 1000).withRequestTimeout(350 * 1000);
				client = new AmazonEC2Client(new BasicAWSCredentials(p.getAccessKey(), p.getSecretKey()), conf);
			} else {
				ClientConfiguration conf = new ClientConfiguration().withConnectionTimeout(350 * 1000)
						.withSocketTimeout(350 * 1000).withRequestTimeout(350 * 1000);
				client = new AmazonEC2Client(new BasicAWSCredentials(p.getAccessKey(), p.getSecretKey()), conf);
			}
			client.setRegion(Region.getRegion(Regions.fromName(region)));
			DescribeVolumesResult result = client
					.describeVolumes(new DescribeVolumesRequest()
							);
			Map<String, String> ret = new HashMap<String, String>();
			for (Volume rec : result.getVolumes()) {
				ret.put(rec.getVolumeId(), rec.getVolumeId() + ":" + rec.getSnapshotId() +":"+rec.getState());
			}
			return ret;
		} catch (AmazonServiceException e) {
			e.printStackTrace();
		}
		return Collections.emptyMap();
	}

}
