package com.mapper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mapper.converter.StudentConverter;
import com.mapper.dto.StudentDto;
import com.mapper.entity.Student;
import com.mapper.repo.StudentRepository;

@RestController
public class StudentController {

	@Autowired StudentRepository studentRepository;
	@Autowired StudentConverter converter;
	
	@GetMapping("/findAll")
	public List<StudentDto> findAll() {
		List<Student> findAll = studentRepository.findAll();
		return converter.entityToDto(findAll);
	}
	
	@GetMapping("/find/{ID}")
	public StudentDto findById(@PathVariable(value = "ID") Long id) {
		Student orElse = studentRepository.findById(id).orElse(null);
		return converter.entityToDto(orElse);
		
	}
	
	@PostMapping("/save")
	public StudentDto save(@RequestBody StudentDto dto) {
		
		Student student = converter.dtoToEntity(dto);
		student=  studentRepository.save(student);
		return converter.entityToDto(student);
	}
	
}
