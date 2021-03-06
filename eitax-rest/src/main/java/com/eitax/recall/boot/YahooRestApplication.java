package com.eitax.recall.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages={
		"com.eitax.recall.yahoo.api",
		"com.eitax.recall.service", 
		"com.eitax.recall.dao",
		"com.eitax.recall.yahoo.job",
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
		"com.eitax.recall.yahoo.model",
		"com.eitax.recall.model",
})
public class YahooRestApplication { 

    private static final Logger log = LoggerFactory.getLogger(YahooRestApplication.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(YahooRestApplication.class);
    }
}
