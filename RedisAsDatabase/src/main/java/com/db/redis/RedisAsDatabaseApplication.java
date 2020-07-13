package com.db.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;

@SpringBootApplication
@EnableRedisRepositories
@EnableScheduling
@Log
@RestController
//@EnableCaching
public class RedisAsDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisAsDatabaseApplication.class, args);
	}

	@Autowired private RedisTemplate<?, ?> template;
	@Autowired private ChannelTopic topic;
	
	
	static int i=1;
	@Scheduled(fixedRate = 1000)
	public void sendMessage() {

		template.convertAndSend(topic.getTopic(), "message "+i);
		i++;
		
	}
	
}
