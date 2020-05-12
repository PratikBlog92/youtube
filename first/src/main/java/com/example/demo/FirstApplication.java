package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Student;

@SpringBootApplication
@RestController
public class FirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
	}

	@GetMapping("/hi/{NAME}")
	public String sayHEllo(@PathVariable(name = "NAME") String firstName) {
		return "Hi "+firstName;
	}
	
	@PostMapping("/hi")
	public String postTest(@RequestBody String name) {
		return "Hello "+ name;
	}
	
	@PostMapping("/student")
	public String getSudent(@RequestBody Student st) {
		return st.toString();
	}

}
