package com.eitax.recall.front.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.amazonaws.regions.Regions;
import com.eitax.recall.front.service.AWSMasterDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AWSMasterDataServiceImpl implements AWSMasterDataService {

	@Override
	public Map<String,String> retrieveRegions() {
		// TODO Auto-generated method stub
		Map<String,String> ret = new HashMap<String,String>();
		List<Regions> list = Arrays.asList(Regions.values());
		list.forEach(rec -> ret.put(rec.getName(), rec.getName()));
		return ret;
	}

	@Override
	public Map<String, String> retrieveLambdaTriggers() {
		return read("static/masterdata/triggers.json");
	}
	private Map<String,String> read(String src){
		try {
			String path = this.getClass().getClassLoader().getResource(src).getPath();
			
			JsonNode root = new ObjectMapper().readTree(new File(path));
			Map<String,String> ret = new LinkedHashMap<String, String>();
			for (JsonNode node : root){
				String key = node.fieldNames().next();
				ret.put(key, key);
			}
			return ret;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Map<String, String> retrieveActions() {
		return read("static/masterdata/actions.json");
	}

	@Override
	public Map<String, String> retrieveAwsNames() {
		return read("static/masterdata/awsNames.json");
	}

}
