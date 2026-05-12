package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class VehicleApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleApplication.class, args);
		System.out.println("Application Started!..");
	}
	@Bean
	@LoadBalanced //for service name to resolve via Eureka Server
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
