package com.eitax.recall.yahoo.rest;

import java.io.IOException;


public interface YahooRestService {
	
	public abstract int retrieveAuctionSearchCount(String appid,String query,int page,int delay, String userAgent,int timeout) throws IOException;
	public abstract String invokeAuctionSearch(String appid,String query,int page,int delay, String userAgent,int timeout) throws IOException;
	public abstract String invokeAuctionItemSearch(String appid,String auctionId,int delay,String userAgent,int timeout) throws IOException;

	public abstract int retrieveAuctionSearchCount2(String appid,String query,int page,int delay, String userAgent,int timeout) throws IOException;
	public abstract com.eitax.recall.yahoo.rest.search.xsd.ResultSet invokeAuctionSearch2(String appid,String query,int page,int delay, String userAgent,int timeout) throws IOException;
	public abstract com.eitax.recall.yahoo.rest.auctionItem.xsd.ResultSet invokeAuctionItemSearch2(String appid,String auctionId,int delay,String userAgent,int timeout) throws IOException;


}
