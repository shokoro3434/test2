package com.eitax.recall.yahoo.auction.boot;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.eitax.recall.yahoo.model.Category;
import com.eitax.recall.yahoo.model.YahooAuctionItem;
import com.eitax.recall.yahoo.rest.YahooRestService;
import com.eitax.recall.yahoo.rest.search.xsd.ItemType;
import com.eitax.recall.yahoo.rest.search.xsd.ResultSet;
import com.eitax.recall.yahoo.service.YahooService;

@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages={
		"com.eitax.recall.service",
		"com.eitax.recall.dao",
		"com.eitax.recall.yahoo.facade",
		"com.eitax.recall.yahoo.service",
		"com.eitax.recall.yahoo.rest",
		"com.eitax.recall.yahoo.dao"
})
@EnableJpaRepositories(basePackages={
		"com.eitax.recall.repository",
		"com.eitax.recall.yahoo.repository"
})
@EntityScan(basePackages={
		"com.eitax.recall.model",
		"com.eitax.recall.yahoo.model",
})

public class YahooSpringBootApplication {

//    public static void main(String[] args) {
//        try (ConfigurableApplicationContext ctx = SpringApplication.run(YahooSpringBootApplication.class, args)) {
//        	YahooSpringBootApplication m = ctx.getBean(YahooSpringBootApplication.class);
//            m.hello();
//        }
//    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(YahooSpringBootApplication.class);
    }

    @Autowired
    private YahooRestService yahooRestService;
    @Autowired
    private YahooService yahooService;
	
    @Scheduled(fixedDelay = 90000) 
    public void hello() {
        String appid = "dj0zaiZpPWlwa2VqOGRqQVFmbSZzPWNvbnN1bWVyc2VjcmV0Jng9Yjc-";
        String query = "ます";
        int page = 1;
        int delay = 1000;
        String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; Touch; rv:11.0) like Gecko";
        int timeout = 10000;
        int aucminBidorbuyPrice = 1;
        int aucmaxBidorbuyPrice = 100;
        try {
        	for (Category c : this.yahooService.findAllCategoryByPath("コンピュータ")){
    			ResultSet rs = yahooRestService.invokeAuctionSearch3(appid, query, page, delay, userAgent, timeout, c.getYCategoryId() , aucminBidorbuyPrice, aucmaxBidorbuyPrice);
    			System.out.println(rs.getTotalResultsAvailable());
    			for (ItemType it : rs.getResult().getItem()){
					String auctionId = it.getAuctionID();
					YahooAuctionItem yci = this.yahooService.findByAuctionId(auctionId);
					if (yci == null){
						yahooService.registerItems3(it,String.valueOf(c.getCategoryId()));
					}
					else{
					}
    			}
        	}
        	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }    
}
