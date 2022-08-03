package com.bootcamp26.webflux.client.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class WebfluxClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxClientApplication.class, args);
	}

}
