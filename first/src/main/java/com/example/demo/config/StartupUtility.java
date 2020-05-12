package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class StartupUtility implements CommandLineRunner,ApplicationRunner {

	private static final Logger log = LoggerFactory.getLogger(StartupUtility.class);

	@Override
	public void run(String... args) throws Exception {
		log.info("****************************** Application started Successfully CommandlineRunner ******************************");
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("****************************** Application started Successfully ApplicationRunner ******************************");

	}

}
