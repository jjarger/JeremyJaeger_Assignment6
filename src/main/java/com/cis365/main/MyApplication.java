package com.cis365.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.cis365.*")
@EnableJpaRepositories(basePackages = {"com.cis365.*"})
@EntityScan(basePackages = {"com.cis365.*"})
public class MyApplication {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(MyApplication.class, args);
	}
	
	
}
