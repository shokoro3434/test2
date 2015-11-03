package com.eitax.recall.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eitax.recall.model.Recall;

public interface RecallRepository extends JpaRepository<Recall, Integer> {

    public List<Recall> findByDelFlag(Integer delFlag);
    public List<Recall> findByEbayFlag(Integer ebayFlag);
    @Modifying
    @Query(value = "update recall.t_recall set yahoo_auction_available_cnt = :yahoo_auction_available_cnt, yahoo_auction_page_cnt = :yahoo_auction_page_cnt ,updated = sysdate where recall_id = :recall_id",nativeQuery=true)
    public abstract int updateYahooAuctionPageCntByRecallId(@Param("yahoo_auction_available_cnt")Integer available,@Param("yahoo_auction_page_cnt")Integer yahooAuctionPageCnt,@Param("recall_id")Integer recallId);

}
