package com.cache.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisCacheServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheServerApplication.class, args);
	}

}
