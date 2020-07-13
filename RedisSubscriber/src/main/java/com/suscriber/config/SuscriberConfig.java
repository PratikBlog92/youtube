package com.suscriber.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import com.suscriber.listnr.RedisMessageListner;

@Configuration
public class SuscriberConfig {
	
	@Bean
	public RedisConnectionFactory getConnectionFactory() {
		return new JedisConnectionFactory();
	}

	
//	@Bean
//	public RedisTemplate<?, ?> getRedisTemplate(){
//		RedisTemplate<?, ?> template = new RedisTemplate();
//		template.setConnectionFactory(getConnectionFactory());
//		return template;
//	}
	
	@Bean
	public ChannelTopic topics() {
		return new ChannelTopic("codeWithPratik");
	}
	
	@Bean
	MessageListenerAdapter adaptor() {
		return new MessageListenerAdapter(new RedisMessageListner());
	}
	
	@Bean
	RedisMessageListenerContainer redisContainer() {
		RedisMessageListenerContainer cnt = new RedisMessageListenerContainer();
		cnt.setConnectionFactory(getConnectionFactory());
		cnt.addMessageListener(adaptor(), topics());
		return cnt;
	}
		 
}
