package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Data;

@Table
@Entity
@Data
public class RestorentOrder extends BaseEntity{

	
	@Enumerated(EnumType.STRING )
	private OrderStatus status;
	
	private String dish;

}


