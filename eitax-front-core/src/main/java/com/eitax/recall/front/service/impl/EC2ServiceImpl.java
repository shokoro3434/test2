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
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeImagesRequest;
import com.amazonaws.services.ec2.model.DescribeImagesResult;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.DescribeSecurityGroupsRequest;
import com.amazonaws.services.ec2.model.DescribeSecurityGroupsResult;
import com.amazonaws.services.ec2.model.DescribeSnapshotsRequest;
import com.amazonaws.services.ec2.model.DescribeSnapshotsResult;
import com.amazonaws.services.ec2.model.Image;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.ec2.model.SecurityGroup;
import com.amazonaws.services.ec2.model.Snapshot;
import com.eitax.recall.front.domain.Profile;
import com.eitax.recall.front.service.EC2Service;
import com.eitax.recall.front.service.ProfileService;

import jp.co.eitan.cloud.itool.api.util.ApiUtils;

@Service
public class EC2ServiceImpl implements EC2Service {
	@Autowired
	private ProfileService profileService;
	@Override
	public Map<String, String> describeSG(String profileName, String region) {
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
			DescribeSecurityGroupsResult result = client.describeSecurityGroups(new DescribeSecurityGroupsRequest());
			Map<String, String> ret = new HashMap<String, String>();
			for (SecurityGroup sg : result.getSecurityGroups()){
				ret.put(sg.getGroupId(),sg.getGroupName()+"-"+sg.getGroupId());
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
			Map<String, String> ret = new HashMap<String, String>();
			DescribeSnapshotsResult describeSnapshotResult = client
					.describeSnapshots(new DescribeSnapshotsRequest().withOwnerIds(p.getAwsId()));
			for (Snapshot s : describeSnapshotResult.getSnapshots()) {
				ret.put(s.getSnapshotId(), s.getSnapshotId() + ":" + s.getState() + ":" + s.getVolumeId());
			}
			return ret;
		} catch (AmazonServiceException e) {
			e.printStackTrace();
		}
		return Collections.emptyMap();
	}
	@Override
	public Map<String, String> describeInstances(String profileName, String region) {
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
			DescribeInstancesResult result = client.describeInstances();
			Map<String, String> ret = new HashMap<String, String>();
			for (Reservation res : result.getReservations()) {
				for (Instance i : res.getInstances()) {
					ret.put(i.getInstanceId(),
							i.getInstanceId() + ":" + ApiUtils.toName(i.getTags()) + ":" + i.getState().getName());
				}
			}

			return ret;
		} catch (AmazonServiceException e) {
			e.printStackTrace();
		}
		return Collections.emptyMap();
	}
	@Override
	public Map<String, String> describeImages(String profileName, String region) {
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
			DescribeImagesResult describeImagesResult = client
					.describeImages(new DescribeImagesRequest().withOwners(p.getAwsId()));
			Map<String, String> ret = new HashMap<String, String>();
			for (Image i : describeImagesResult.getImages()) {
				ret.put(i.getImageId(), i.getImageId() + ":" + i.getState() + ":" + i.getName());
			}
			return ret;
		} catch (AmazonServiceException e) {
			e.printStackTrace();
		}
		return Collections.emptyMap();
	}

}
