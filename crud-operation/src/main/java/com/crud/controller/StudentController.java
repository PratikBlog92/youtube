package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Student;
import com.crud.repo.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired	private StudentRepository studentRepository;
	
//	localhost:8080/student/create
	//save student in database
	@PostMapping("/create")
	public Student save(@RequestBody Student student) {
		Student save = studentRepository.save(student);
		return save;
	}
	
//	localhost:8080/student/findAll
	// find list of student
	@GetMapping("/findAll")
	public List<Student> findAllStuent(){
		List<Student> findAll = studentRepository.findAll();
		return findAll;
	}
	//localhost:8080/student/find/1
	//find student by id
	@GetMapping("/find/{ID}")
	public Student find(@PathVariable(value = "ID")Long id) {
		
		Student orElseThrow = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student is not present database"));
		return orElseThrow;
		
	}
	

	// update student
//	localhost:8080/student/update
	@PutMapping("/update")
	public Student update(@RequestBody Student student) {
		Student save = studentRepository.save(student);
		return save;
	}
	
	//delete student
	//localhost:8080/student/delete/1
	@DeleteMapping("/delete/{ID}")
public String delete(@PathVariable(value = "ID")Long id) {
		
		Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student is not present database"));
		studentRepository.delete(student);
		return "Student deleted successfully ...!";
	}
}
