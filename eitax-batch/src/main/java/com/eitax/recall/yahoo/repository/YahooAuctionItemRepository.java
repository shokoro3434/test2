package com.eitax.recall.yahoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eitax.recall.yahoo.model.YahooAuctionItem;

public interface YahooAuctionItemRepository extends JpaRepository<YahooAuctionItem, Integer>{

	public abstract YahooAuctionItem findByAuctionId(String auctionId);
	public abstract List<YahooAuctionItem> deleteByAuctionId(String auctionId);
    @Modifying
    @Query(value = "update recall.t_yahoo_auction_item set mark_id = :markId ,updated = sysdate where yahoo_auction_item_id = :yahooAuctionItemId",nativeQuery=true)
    public abstract int updateMarkId(@Param("markId")Integer markId,@Param("yahooAuctionItemId")Integer yahooAuctionItemId);
}
