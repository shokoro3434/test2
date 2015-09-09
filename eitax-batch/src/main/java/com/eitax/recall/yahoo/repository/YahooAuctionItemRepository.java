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

    @Query(value = "select * from recall.t_yahoo_auction_item where notified = 0 and (bid_or_buy <> 0 and bid_or_buy <= :bidOrBuy) and end_time >= TO_CHAR((sysdate-30/3600),'YYYY-MM-DD\"T\"HH24:MI:SS') order by end_time asc",nativeQuery=true)
    public abstract List<YahooAuctionItem> findByBidOrBuy(@Param("bidOrBuy")Integer bidOrBuy);

    @Modifying
    @Query(value = "update recall.t_yahoo_auction_item set notified = :notified ,updated = sysdate where yahoo_auction_item_id = :yahooAuctionItemId",nativeQuery=true)
    public int updateAuctionItemByPK(@Param("notified")Integer notified,@Param("yahooAuctionItemId")Integer yahooAuctionItemId);

}
