package com.eitan.recall.util;

import java.io.StringReader;

import javax.xml.bind.DataBindingException;
import javax.xml.bind.JAXB;

public final class RecallUtils {
	public static final String toJson(String jsonp){
		final String prefix = "loaded(";
		final String suffix = ")";
		return jsonp.substring(0+prefix.length(), jsonp.length()-suffix.length());
	}
	public static <T> T unmarshal (String xml,Class<T> c){
		StringReader sr = null;
		try{
			sr = new StringReader(xml.toString());
			return JAXB.unmarshal(sr, c);
		}
		catch(DataBindingException e){
			e.printStackTrace();
			return null;
		}
		finally{
			sr.close();
		}
	}
}
