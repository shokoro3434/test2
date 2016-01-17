package com.eitax.recall.front.service.impl;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.elasticloadbalancing.model.LoadBalancerDescription;
import com.amazonaws.services.elasticloadbalancing.model.DescribeLoadBalancersResult;
import com.amazonaws.services.elasticloadbalancing.model.DescribeLoadBalancersRequest;
import com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingClient;
import com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancing;
import com.eitax.recall.front.domain.Profile;
import com.eitax.recall.front.service.ELBService;
import com.eitax.recall.front.service.ProfileService;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ELBServiceImpl implements ELBService{
	@Autowired
	private ProfileService profileService;

	@Override
	public Map<String, String> describeLoadBalancers(String profileName, String region) {
		try {
			Profile p = profileService.findOne(profileName);
			AmazonElasticLoadBalancing client = null;
			if (System.getProperty("useProxy") != null) {
				ClientConfiguration conf = new ClientConfiguration().withProxyHost(System.getProperty("proxyHost"))
						.withProxyPort(Integer.valueOf(System.getProperty("proxyPort")))
						.withProxyUsername(System.getProperty("proxyUsername"))
						.withProxyPassword(System.getProperty("proxyPassword")).withConnectionTimeout(350 * 1000)
						.withSocketTimeout(350 * 1000).withRequestTimeout(350 * 1000);
				client = new AmazonElasticLoadBalancingClient(new BasicAWSCredentials(p.getAccessKey(), p.getSecretKey()), conf);
			} else {
				ClientConfiguration conf = new ClientConfiguration().withConnectionTimeout(350 * 1000)
						.withSocketTimeout(350 * 1000).withRequestTimeout(350 * 1000);
				client = new AmazonElasticLoadBalancingClient(new BasicAWSCredentials(p.getAccessKey(), p.getSecretKey()), conf);
			}
			client.setRegion(Region.getRegion(Regions.fromName(region)));
			DescribeLoadBalancersResult result = client
					.describeLoadBalancers(new DescribeLoadBalancersRequest()
							);
			Map<String, String> ret = new HashMap<String, String>();
			for (LoadBalancerDescription rec : result.getLoadBalancerDescriptions()) {
				ret.put(rec.getLoadBalancerName(), rec.getLoadBalancerName() + ":" + rec.getVPCId() +":"+rec.getSubnets());
			}
			return ret;
		} catch (AmazonServiceException e) {
			e.printStackTrace();
		}
		return Collections.emptyMap();
	}

}
