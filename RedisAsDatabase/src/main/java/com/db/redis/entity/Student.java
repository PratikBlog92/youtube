package com.db.redis.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
@RedisHash(value = "std")
public class Student implements Serializable {

	@Id private String id;
	@Indexed private String name;
	@Indexed private String city;
	
}
