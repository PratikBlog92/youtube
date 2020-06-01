package com.mapper.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapper.domain.Student;
import com.mapper.repo.StudentRepo;

import lombok.extern.java.Log;

@Component
@Log
public class StartupUility implements CommandLineRunner{

	
	@Value("${demo.json.string}") private String json;
	@Autowired private StudentRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		ObjectMapper mapper =new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		Student value = mapper.readValue(json, Student.class);
		Student save = repo.save(value);
		
		log.info(" Student info "+save.toString());
		
	}


}
