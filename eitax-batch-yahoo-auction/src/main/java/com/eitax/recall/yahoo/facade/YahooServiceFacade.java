package com.eitax.recall.yahoo.facade;

import java.io.IOException;

public interface YahooServiceFacade {
	
	public int updateAuctionItem(Integer yahooAuctionItemId,Integer markId);

	public void ack() throws Exception;

	public void registerAuctionItems2() throws IOException;

}
