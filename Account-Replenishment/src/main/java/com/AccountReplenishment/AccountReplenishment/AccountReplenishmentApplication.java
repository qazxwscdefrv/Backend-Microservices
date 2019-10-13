package com.AccountReplenishment.AccountReplenishment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaAuditing
public class AccountReplenishmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountReplenishmentApplication.class, args);
	}

}
