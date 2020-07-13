package com.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Log
@SpringBootApplication
public class RedApplication implements ApplicationRunner{
	
	@Autowired
	Environment env;

	public static void main(String[] args) {
		SpringApplication.run(RedApplication.class, args);
	}

	
	@Autowired StudentRepo repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Student s  = new Student("1", "firstname", "lastname");
		Student save = repo.save(s);
		log.warning(save.toString());
	}

	
	
}
