package com.BankSystemAPI.BankSystemAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BankSystemApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankSystemApiApplication.class, args);
	}

}
