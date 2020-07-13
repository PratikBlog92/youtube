package com.suscriber.listnr;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Component
@Log
public class RedisMessageListner implements MessageListener{

	RedisSerializer<Object> desc = new JdkSerializationRedisSerializer();
	
	@Override
	public void onMessage(Message message, byte[] pattern) {
		String deserialize = (String)desc.deserialize(message.getBody());
		
		log.info(deserialize);
	}

}
