package com.eitax.recall.yahoo.service;

import java.util.List;

import com.eitax.recall.yahoo.model.YahooApiCall;
import com.eitax.recall.yahoo.model.YahooAuctionItem;
import com.eitax.recall.yahoo.rest.auctionItem.xsd.ResultSet;
import com.eitax.recall.yahoo.rest.search.xsd.ItemType;

import net.sf.json.JSONObject;

public interface YahooService {
    public abstract YahooApiCall registerYahooApiCallAndFindYahooApi();
	public abstract void updateApiCallCount(Integer yahooApiCallId,Integer cnt);
	public abstract int updateAuctionItemMarkId(Integer yahooAuctionItemId,Integer markId);
	public abstract YahooAuctionItem findByAuctionId (String auctionId);
	public abstract List<YahooAuctionItem> findByBidOrBuy(Integer bob);
	public abstract int updateAuctionItemByPK(Integer notified,Integer yahooAuctionItemId);

	public abstract void registerItems2(ItemType item,Integer recallId,ResultSet auctionItem);

}
