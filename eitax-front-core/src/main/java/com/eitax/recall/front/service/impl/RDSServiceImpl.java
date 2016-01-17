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
import com.amazonaws.services.rds.AmazonRDS;
import com.amazonaws.services.rds.AmazonRDSClient;
import com.amazonaws.services.rds.model.DBInstance;
import com.amazonaws.services.rds.model.DBSnapshot;
import com.amazonaws.services.rds.model.DescribeDBInstancesRequest;
import com.amazonaws.services.rds.model.DescribeDBInstancesResult;
import com.amazonaws.services.rds.model.DescribeDBSnapshotsRequest;
import com.amazonaws.services.rds.model.DescribeDBSnapshotsResult;
import com.eitax.recall.front.domain.Profile;
import com.eitax.recall.front.service.ProfileService;
import com.eitax.recall.front.service.RDSService;

@Service
public class RDSServiceImpl implements RDSService {
	@Autowired
	private ProfileService profileService;
	@Override
	public Map<String, String> describeInstances(String profileName, String region) {
		try {
			Profile p = profileService.findOne(profileName);
			AmazonRDS client = null;
			if (System.getProperty("useProxy") != null) {
				ClientConfiguration conf = new ClientConfiguration().withProxyHost(System.getProperty("proxyHost"))
						.withProxyPort(Integer.valueOf(System.getProperty("proxyPort")))
						.withProxyUsername(System.getProperty("proxyUsername"))
						.withProxyPassword(System.getProperty("proxyPassword")).withConnectionTimeout(350 * 1000)
						.withSocketTimeout(350 * 1000).withRequestTimeout(350 * 1000);
				client = new AmazonRDSClient(new BasicAWSCredentials(p.getAccessKey(), p.getSecretKey()), conf);
			} else {
				ClientConfiguration conf = new ClientConfiguration().withConnectionTimeout(350 * 1000)
						.withSocketTimeout(350 * 1000).withRequestTimeout(350 * 1000);
				client = new AmazonRDSClient(new BasicAWSCredentials(p.getAccessKey(), p.getSecretKey()), conf);
			}
			client.setRegion(Region.getRegion(Regions.fromName(region)));
			DescribeDBInstancesResult result = client.describeDBInstances(new DescribeDBInstancesRequest()
					);
			Map<String, String> ret = new HashMap<String, String>();
			for (DBInstance i : result.getDBInstances()) {
				ret.put(i.getDBInstanceIdentifier(), i.getEngine()+":"+i.getDBInstanceIdentifier()+":"+i.getDBInstanceStatus());
			}
			return ret;
		} catch (AmazonServiceException e) {
			e.printStackTrace();
		}
		return Collections.emptyMap();
	}
	@Override
	public Map<String, String> describeSnapshots(String profileName, String region) {
		try {
			Profile p = profileService.findOne(profileName);
			AmazonRDS client = null;
			if (System.getProperty("useProxy") != null) {
				ClientConfiguration conf = new ClientConfiguration().withProxyHost(System.getProperty("proxyHost"))
						.withProxyPort(Integer.valueOf(System.getProperty("proxyPort")))
						.withProxyUsername(System.getProperty("proxyUsername"))
						.withProxyPassword(System.getProperty("proxyPassword")).withConnectionTimeout(350 * 1000)
						.withSocketTimeout(350 * 1000).withRequestTimeout(350 * 1000);
				client = new AmazonRDSClient(new BasicAWSCredentials(p.getAccessKey(), p.getSecretKey()), conf);
			} else {
				ClientConfiguration conf = new ClientConfiguration().withConnectionTimeout(350 * 1000)
						.withSocketTimeout(350 * 1000).withRequestTimeout(350 * 1000);
				client = new AmazonRDSClient(new BasicAWSCredentials(p.getAccessKey(), p.getSecretKey()), conf);
			}
			client.setRegion(Region.getRegion(Regions.fromName(region)));
			Map<String, String> ret = new HashMap<String, String>();
			DescribeDBSnapshotsResult result = client.describeDBSnapshots(new DescribeDBSnapshotsRequest()
					.withSnapshotType("manual")
					);
			for (DBSnapshot s : result.getDBSnapshots()){
				ret.put(s.getDBSnapshotIdentifier(), s.getDBSnapshotIdentifier()+":"+s.getDBInstanceIdentifier()+":"+s.getStatus());
			}
			return ret;
		} catch (AmazonServiceException e) {
			e.printStackTrace();
		}
		return Collections.emptyMap();
	}
	
}
