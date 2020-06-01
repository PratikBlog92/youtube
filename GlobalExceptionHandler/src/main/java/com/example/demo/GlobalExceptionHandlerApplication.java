package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dto.Student;
import com.example.demo.repo.StudentRepository;

@SpringBootApplication
public class GlobalExceptionHandlerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(GlobalExceptionHandlerApplication.class, args);
	}

	@Autowired private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Student pratik = Student.builder().firstName("Pratik").className("10").address("Nagpur").build();
		Student shrikant = Student.builder().firstName("Shrikant").className("10").address("Patrood").build();
		Student shankar = Student.builder().firstName("Shankar").className("10").address("Aurangabad").build();
		Student sandeep = Student.builder().firstName("Sandeep").className("10").address("Amaravati").build();
		Student shubham = Student.builder().firstName("Shubham").className("10").address("Nagpur").build();
		Student sam = Student.builder().firstName("Sam").className("10").address("Pune").build();
		Student omi = Student.builder().firstName("Omprakash").className("10").address("pune").build();
		Student akash = Student.builder().firstName("Akash").className("10").address("Bihar").build();
		Student mayur = Student.builder().firstName("Mayur").className("10").address("Nagpur").build();
		Student teja = Student.builder().firstName("Teja").className("10").address("Nagpur").build();

		List<Student> students = new ArrayList<Student>();
		students.add(pratik);
		students.add(shrikant);
		students.add(shankar);
		students.add(sandeep);
		students.add(shubham);
		students.add(sam);
		students.add(omi);
		students.add(akash);
		students.add(mayur);
		students.add(teja);
		
		studentRepository.saveAll(students);
	
	
	}

}
