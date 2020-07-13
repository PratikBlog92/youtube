package com.mapper;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Builder
@RedisHash("stud")
@ToString
public class Student implements Serializable{
	@Id private String id;
    @Indexed private String firstname;
    @Indexed private String lastname;
}
