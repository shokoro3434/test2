package com.eitax.recall.front.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//@RestController
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages={
		"com.eitax.recall.front.boot",
		"com.eitax.recall.front.dao",
		"com.eitax.recall.front.service",
		"com.eitax.recall.front.web",
		"jp.co.eitan.cloud.itool.api",
		"jp.co.eitan.cloud.itool.api.model",
})
@EnableJpaRepositories(basePackages={
		"com.eitax.recall.front.repository",
})
@EntityScan(basePackages={
		"com.eitax.recall.front.domain",
})
public class App {
	public static void main(String [] args){
		SpringApplication.run(App.class, args);
	}
}