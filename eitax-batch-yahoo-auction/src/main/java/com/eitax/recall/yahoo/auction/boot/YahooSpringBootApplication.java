package com.eitax.recall.yahoo.auction.boot;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.eitax.recall.yahoo.rest.YahooRestService;
import com.eitax.recall.yahoo.rest.search.xsd.ItemType;
import com.eitax.recall.yahoo.rest.search.xsd.ResultSet;

@SpringBootApplication
@ComponentScan(basePackages={
		"com.eitax.recall.yahoo.rest"
})

public class YahooSpringBootApplication {

    public static void main(String[] args) {
        try (ConfigurableApplicationContext ctx = SpringApplication.run(YahooSpringBootApplication.class, args)) {
        	YahooSpringBootApplication m = ctx.getBean(YahooSpringBootApplication.class);
            m.hello();
        }
    }
    
    @Autowired
    private YahooRestService yahooRestService;
    
    public void hello() {
        System.out.println("Hello Spring Boot!!");
        String appid = "dj0zaiZpPWlwa2VqOGRqQVFmbSZzPWNvbnN1bWVyc2VjcmV0Jng9Yjc-";
        String query = "ます";
        int page = 1;
        int delay = 1000;
        String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; Touch; rv:11.0) like Gecko";
        int timeout = 10000;
        String categoryId = "2084239343";
        int aucminBidorbuyPrice = 1;
        int aucmaxBidorbuyPrice = 10;
        try {
			ResultSet rs = yahooRestService.invokeAuctionSearch3(appid, query, page, delay, userAgent, timeout, categoryId, aucminBidorbuyPrice, aucmaxBidorbuyPrice);
			System.out.println(rs.getTotalResultsAvailable());
			for (ItemType it : rs.getResult().getItem()){
				System.out.println(it.getTitle());
				System.out.println(it.getAuctionItemUrl());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }    
}
