package com.eitax.recall.yahoo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eitax.recall.yahoo.dao.YahooAuctionItemDAO;
import com.eitax.recall.yahoo.model.YahooAuctionItem;
import com.eitax.recall.yahoo.repository.YahooAuctionItemRepository;

import java.util.List;

@Component
public class YahooAuctionItemDAOImpl implements YahooAuctionItemDAO {
	@Autowired
	private YahooAuctionItemRepository yahooAuctionItemRepository;
	
	public YahooAuctionItem save (YahooAuctionItem yai){
		return yahooAuctionItemRepository.save(yai);
	}
	public YahooAuctionItem findByAuctionId (String auctionId){
		return yahooAuctionItemRepository.findByAuctionId(auctionId);
	}
	public List<YahooAuctionItem> deleteByAuctionId(String auctionId){
		return yahooAuctionItemRepository.deleteByAuctionId(auctionId);
	}
	public int updateMarkId(Integer yahooAuctionItemId, Integer markId) {
		return this.yahooAuctionItemRepository.updateMarkId(markId, yahooAuctionItemId);
	}
	@Override
	public List<YahooAuctionItem> findByBidOrBuy(Integer bob) {
		// TODO Auto-generated method stub
		return this.yahooAuctionItemRepository.findByBidOrBuy(bob);
	}
	@Override
	public int updateAuctionItemByPK(Integer notified, Integer yahooAuctionItemId) {
		// TODO Auto-generated method stub
		return this.yahooAuctionItemRepository.updateAuctionItemByPK(notified,yahooAuctionItemId);
	}

}

