package com.cache.server.configure;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
public class RedisConfiguration {

	@Bean
	RedisConnectionFactory connectionFactory() {
		return new JedisConnectionFactory();
	}
	
	@Bean 
	RedisCacheConfiguration cacheConfiguration() {
		return RedisCacheConfiguration.defaultCacheConfig()
		.entryTtl(Duration.ofSeconds(10))
		.disableCachingNullValues();
	}
	
	@Bean
	RedisCacheManager cacheManager() {
		return RedisCacheManager.builder(connectionFactory())
		.cacheDefaults(cacheConfiguration())
		.transactionAware()
		.build();
	}
}
