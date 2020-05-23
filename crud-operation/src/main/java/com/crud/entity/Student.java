package com.crud.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "student_details")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "student_name")
	private String name;
	private String className;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address add;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Subjects> subjects;

	@ManyToMany(cascade = {CascadeType.ALL})
	private Set<Hobby> hobies = new HashSet<>();
	
}
