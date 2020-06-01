package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dto.Student;
import com.example.demo.repo.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ExceptionTestController {

	@GetMapping("/test")
	public String sayHello() {
		throw new RuntimeException("***************Exception Occured************ ");
	}
	
	@Autowired StudentRepository studentRepo;
	
	@GetMapping("/student/{ID}")
	public Student getStudent(@PathVariable(value = "ID") Long id)
	{
		return studentRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Student Not found") );
		
	}
}
