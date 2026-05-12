package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class InsuranceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceServerApplication.class, args);
		System.out.println("INSURANCE SERVICE STARTED....");
	}
	
	@Bean
	 RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	

}
