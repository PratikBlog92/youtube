package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.booleanTest.BooleeanTest;
import com.crud.repo.BooleanRepository;

@RestController
public class BooleanConroller {

	@Autowired private BooleanRepository repo;
	
	@PostMapping("/boolean/create")
	public BooleeanTest create(BooleeanTest bt)
	{
		return repo.save(bt);
	}
	
}
