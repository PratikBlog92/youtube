package com.db.redis.config;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;

@Configuration
public class RedisConfig {
	
	@Bean
	public RedisConnectionFactory getConnectionFactory() {
		return new JedisConnectionFactory();
	}

	
	@Bean
	@Primary
	public RedisTemplate<?, ?> getRedisTemplate(){
		RedisTemplate<?, ?> template = new RedisTemplate();
		template.setConnectionFactory(getConnectionFactory());
		return template;
	}
	
//	 @Bean
//	   public RedisCacheManager cacheManager() {
//		RedisCacheManager rcm = RedisCacheManager.builder(getConnectionFactory())
//		  .cacheDefaults(cacheConfiguration())
//		  .transactionAware()
//		  .build();
//		return rcm;
//	   }
//	 
//	 @Bean
//	   public RedisCacheConfiguration cacheConfiguration() {
//		RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig()
//		  .entryTtl(Duration.ofSeconds(6))
//		  .disableCachingNullValues();	
//		return cacheConfig;
//	   }
	
	@Bean
	public ChannelTopic topics() {
		return new ChannelTopic("codeWithPratik");
	}
		 
}
