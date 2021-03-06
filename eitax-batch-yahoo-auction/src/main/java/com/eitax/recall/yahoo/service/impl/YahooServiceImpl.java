package com.eitax.recall.yahoo.service.impl;

import java.util.List;
import java.util.TimeZone;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eitax.recall.yahoo.dao.YahooApiCallDAO;
import com.eitax.recall.yahoo.dao.YahooApiDAO;
import com.eitax.recall.yahoo.dao.YahooAuctionItemDAO;
import com.eitax.recall.yahoo.dao.YahooCategoryDAO;
import com.eitax.recall.yahoo.model.Category;
import com.eitax.recall.yahoo.model.YahooApi;
import com.eitax.recall.yahoo.model.YahooApiCall;
import com.eitax.recall.yahoo.model.YahooAuctionItem;
import com.eitax.recall.yahoo.rest.auctionItem.xsd.ResultSet;
import com.eitax.recall.yahoo.rest.search.xsd.ItemType;
import com.eitax.recall.yahoo.service.YahooService;

@Component
public class YahooServiceImpl implements YahooService {

	@Autowired
	private YahooAuctionItemDAO yahooAuctionItemDAO;
	@Autowired
	private YahooApiCallDAO yahooApiCallDAO;
	@Autowired
	private YahooApiDAO yahooApiDAO;
	@Autowired
	private YahooCategoryDAO yahooCategoryDAO;


	@Override
	@Transactional
	public YahooApiCall registerYahooApiCallAndFindYahooApi() {
		DateTime now = DateTime.now().withZone(DateTimeZone.forTimeZone(TimeZone.getTimeZone("JST")))
				.withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0);
		String yyyyMMdd = now.toString("yyyyMMdd");
		List<YahooApiCall> list = yahooApiCallDAO.findByCallYyyymmdd(now.toString("yyyyMMdd"));
		if (0 == list.size()) {
			List<YahooApi> yahooApiList = yahooApiDAO.findAll();
			for (YahooApi ya : yahooApiList) {
				YahooApiCall yap = new YahooApiCall();
				yap.setCnt(0);
				yap.setYyyymmdd(yyyyMMdd);
				yap.setDelFlag(0);
				yap.setYahooApi(ya);
				yahooApiCallDAO.save(yap);
			}
			list = yahooApiCallDAO.findByCallYyyymmdd(now.toString("yyyyMMdd"));
		}
		YahooApiCall apc = list.get(0);
		return apc;
	}

	@Override
	@Transactional
	public void updateApiCallCount(Integer yahooApiCallId, Integer cnt) {
		yahooApiCallDAO.updateCallCount(yahooApiCallId, cnt);
	}
	@Override
	@Transactional
	public int updateAuctionItemMarkId(Integer yahooAuctionItemId, Integer markId) {
		// TODO Auto-generated method stub
		return this.yahooAuctionItemDAO.updateMarkId(yahooAuctionItemId, markId);
	}

	@Override
	public YahooAuctionItem findByAuctionId(String auctionId) {
		// TODO Auto-generated method stub
		return this.yahooAuctionItemDAO.findByAuctionId(auctionId);
	}

	@Override
	public List<YahooAuctionItem> findByBidOrBuy(Integer bob) {
		// TODO Auto-generated method stub
		return this.yahooAuctionItemDAO.findByBidOrBuy(bob);
	}

	@Override
	@Transactional
	public int updateAuctionItemByPK(Integer notified, Integer yahooAuctionItemId) {
		// TODO Auto-generated method stub
		return this.yahooAuctionItemDAO.updateAuctionItemByPK(notified,yahooAuctionItemId);
	}

	@Override
	public void registerItems2(ItemType item, Integer recallId, ResultSet detail) {
		// TODO Auto-generated method stub
		String auctionId = item.getAuctionID();
		yahooAuctionItemDAO.deleteByAuctionId(auctionId);

//		int storeFlag = detail.getResult().getOption().getStoreIcon() != null ? 1 : 0;

		int storeFlag = item.getOption().getStoreIcon() != null ? 1 : 0;
		
		YahooAuctionItem tmp = yahooAuctionItemDAO.findByAuctionId(auctionId);

		YahooAuctionItem yai = new YahooAuctionItem();
		yai.setTitle(item.getTitle());
		yai.setEndTime(item.getEndTime());
//		yai.setStartTime(detail.getResult().getStartTime());
		yai.setCurrentPrice((int)item.getCurrentPrice());
		yai.setAuctionId(item.getAuctionID());
//		yai.setCategoryId(detail.getResult().getCategoryID());
		yai.setBidOrBuy(item.getBidOrBuy() != null ? item.getBidOrBuy().intValue() : 0);
		yai.setSellerId(item.getSeller().getId());
		yai.setAuctionItemUrl(item.getAuctionItemUrl());
		yai.setRecallId(recallId);
		yai.setStoreFlag(storeFlag);
		yai.setBids(item.getBids().intValue());
		yai.setMarkId(tmp != null ? tmp.getMarkId() : 2);
		yai.setAuctionId(auctionId);
		
		yahooAuctionItemDAO.save(yai);

	}

	@Override
	public List<Category> findAllCategoryByPath(String path){
		return this.yahooCategoryDAO.findByPath(path);
	}

	@Override
	public void registerItems3(ItemType item,String categoryId) {
		// TODO Auto-generated method stub
		String auctionId = item.getAuctionID();
		yahooAuctionItemDAO.deleteByAuctionId(auctionId);

		YahooAuctionItem yai = new YahooAuctionItem();
		yai.setTitle(item.getTitle());
		yai.setEndTime(item.getEndTime());
//		yai.setStartTime(nulldetail.getResult().getStartTime());
		yai.setCurrentPrice((int)item.getCurrentPrice());
		yai.setAuctionId(item.getAuctionID());
		yai.setCategoryId(categoryId);
		yai.setBidOrBuy(item.getBidOrBuy() != null ? item.getBidOrBuy().intValue() : 0);
		yai.setSellerId(item.getSeller().getId());
		yai.setAuctionItemUrl(item.getAuctionItemUrl());
//		yai.setRecallId(recallId);
//		yai.setStoreFlag(storeFlag);
		yai.setBids(item.getBids().intValue());
//		yai.setMarkId(tmp != null ? tmp.getMarkId() : 2);
		yai.setAuctionId(auctionId);
		yai.setJunkFlag(1);
		
		yahooAuctionItemDAO.save(yai);
		
	}

}
