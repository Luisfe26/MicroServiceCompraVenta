package com.orderpurchaseservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrderPurchaseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderPurchaseServiceApplication.class, args);
	}

}
