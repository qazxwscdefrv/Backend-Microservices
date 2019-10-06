package com.AccountReplenishment.AccountReplenishment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AccountReplenishmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountReplenishmentApplication.class, args);
	}

}
