package com.mapper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapper.domain.Student;
import com.mapper.domain.mixin.StudentIgnoreMixin;
import com.mapper.repo.StudentRepo;

@RestController
public class StudentController {

	@Autowired private StudentRepo repo;
	
	@GetMapping("/findAllStudent")
	public List<Student> getAllStudent() throws JsonProcessingException{
		List<Student> students = repo.findAll();
		return students;
	}
	
	@GetMapping("/findAllStudent/new")
	public ResponseEntity<?> getAllStudents() throws JsonProcessingException{
		List<Student> students = repo.findAll();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.addMixIn(Student.class, StudentIgnoreMixin.class);

		String jsonString = mapper.writeValueAsString(students);
		
		
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(jsonString);
	}
	
}
