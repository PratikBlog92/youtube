package com.db.redis.strtupUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.db.redis.entity.Student;
import com.db.redis.repo.StudentRepo;

import lombok.extern.java.Log;

@Log
@Component
public class Strtup implements CommandLineRunner {

	@Autowired StudentRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Student st = new Student();
		st.setCity("Nagpur");
		st.setId("1");
		st.setName("Pratik");
		
		Student save = repo.save(st);
	
	log.info("======================>> "+save.toString());
	}

}
