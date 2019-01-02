package com.accenture.tcf.bars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarsApplication.class, args);
	}

}

