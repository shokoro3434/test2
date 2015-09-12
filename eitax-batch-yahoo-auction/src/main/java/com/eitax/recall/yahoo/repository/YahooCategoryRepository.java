package com.eitax.recall.yahoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eitax.recall.yahoo.model.Category;

public interface YahooCategoryRepository extends JpaRepository<Category, Integer>{

//	public abstract YahooAuctionItem save(YahooAuctionItem yai);
//	public abstract YahooAuctionItem findByAuctionId(String auctionId);
//	public abstract List<YahooAuctionItem> deleteByAuctionId(String auctionId);
	public abstract void deleteByYCategoryId(Integer yCategoryId);
//    @Query(value = "select * from recall.m_category where category_path like '%:path%')",nativeQuery=true)
    public abstract List<Category> findByCategoryPathContains(String categoryPath);

}
