package com.SendingMoney.SendingMoney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SendingMoneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendingMoneyApplication.class, args);
	}

}
