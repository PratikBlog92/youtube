package com.configclient.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
public class ConfigurationClientApplication {

	@Value("${config.evniornment}")
	private String envirnment;

	@GetMapping("/get")
	public String getEnviornmt(){
		return envirnment;
	}

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationClientApplication.class, args);
	}

}
