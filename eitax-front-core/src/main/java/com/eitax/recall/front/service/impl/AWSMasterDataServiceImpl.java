package com.eitax.recall.front.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.amazonaws.regions.Regions;
import com.eitax.recall.front.service.AWSMasterDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.eitan.cloud.itool.api.model.ActionSysRel;

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

	private JsonNode readAsJsonNode(String src){
		try {
			String path = this.getClass().getClassLoader().getResource(src).getPath();
			
			JsonNode root = new ObjectMapper().readTree(new File(path));
			return root;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	private Map<String,String> read(String src,String filter){
		try {
			String path = this.getClass().getClassLoader().getResource(src).getPath();
			
			JsonNode root = new ObjectMapper().readTree(new File(path));
			Map<String,String> ret = new LinkedHashMap<String, String>();
			for (JsonNode node : root){
				String key = node.fieldNames().next();
				String value = node.findValue(key).asText();
				if (StringUtils.isEmpty(filter) || key.startsWith(filter)){
					ret.put(key, value);
				}
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
		return read("static/masterdata/actions.json",null);
	}
	@Override
	public Map<String, String> retrieveAwsNames(String filter) {
		return read("static/masterdata/awsNames.json",filter);
	}
	@Override
	public Map<String, String> retrieveLambdaTriggers() {
		return read("static/masterdata/triggers.json",null);
	}
	@Override
	public Map<String, String> retrieveAwsNames() {
		return retrieveAwsNames(null);
	}
	@Override
	public Map<String, String> retrieveActions(String filter) {
		return read("static/masterdata/actions.json",filter);
	}

	@Override
	public Map<String, String> retrieveCronTypes() {
		// TODO Auto-generated method stub
		return read("static/masterdata/cron-types.json",null);
	}

	@Override
	public Map<String, String> retrieveIpProtocols() {
		// TODO Auto-generated method stub
		return read("static/masterdata/ip-protocols.json",null);
	}

	@Override
	public JsonNode retrieveActionSysRel() {
		// TODO Auto-generated method stub
		return readAsJsonNode("static/masterdata/action-sys-rel.json");
	}

}
