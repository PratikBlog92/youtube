package com.crud.entity.booleanTest;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.crud.config.BooleanConfig;

import lombok.Data;

@Table
@Entity
@Data
public class BooleeanTest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Convert(converter=BooleanConfig.class)
	private Boolean isPublished;
	
}
