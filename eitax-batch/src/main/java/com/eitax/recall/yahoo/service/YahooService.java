package com.eitax.recall.yahoo.service;

import java.util.List;

import com.eitax.recall.yahoo.model.YahooApiCall;
import com.eitax.recall.yahoo.model.YahooAuctionItem;

import net.sf.json.JSONObject;

public interface YahooService {
	public abstract void registerItems(JSONObject item,Integer recallId,String itemJson);
    public abstract YahooApiCall registerYahooApiCallAndFindYahooApi();
	public abstract void updateApiCallCount(Integer yahooApiCallId,Integer cnt);
	public abstract int updateAuctionItemMarkId(Integer yahooAuctionItemId,Integer markId);
	public abstract YahooAuctionItem findByAuctionId (String auctionId);
	public abstract List<YahooAuctionItem> findByBidOrBuy(Integer bob);
	public abstract int updateAuctionItemByPK(Integer notified,Integer yahooAuctionItemId);
}
