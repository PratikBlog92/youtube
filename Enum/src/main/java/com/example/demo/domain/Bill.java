package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Table
@Entity
@Data
public class Bill extends BaseEntity{

	private String custmerName;
	private String totalAmount;


}
