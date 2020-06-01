package com.mapper.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate = new Date();
	

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate = new Date();

	private String name;
	
	private String username;
	
	private String password;
}
