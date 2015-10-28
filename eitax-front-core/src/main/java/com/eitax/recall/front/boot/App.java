package com.eitax.recall.front.boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eitax.recall.front.dao.CustomerDAO;

@RestController
@EnableAutoConfiguration
//@SpringBootApplication
@ComponentScan(basePackages={
		"com.eitax.recall.front.boot",
		"com.eitax.recall.front.dao",
		"com.eitax.recall.front.service",
		"com.eitax.recall.front.web",
})
@EnableJpaRepositories(basePackages={
		"com.eitax.recall.front.repository",
})
@EntityScan(basePackages={
		"com.eitax.recall.front.domain",
})
public class App {
	@Autowired
	private CustomerDAO customerDAO;
	@RequestMapping("/")
	private String home(){
		customerDAO.findAll().forEach(System.out::println);;
		return "Hello World hoge";
	}
	public static void main(String [] args){
		SpringApplication.run(App.class, args);
	}
}
