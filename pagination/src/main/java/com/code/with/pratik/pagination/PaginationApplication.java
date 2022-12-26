package com.code.with.pratik.pagination;

import com.code.with.pratik.pagination.domain.Student;
import com.code.with.pratik.pagination.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PaginationApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(PaginationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Student> students = new ArrayList<>();
		students.add(Student.builder().name("Pratik").city("UK").build());
		students.add(Student.builder().name("Neha").city("UK").build());
		students.add(Student.builder().name("Shubham").city("Scotland").build());
		students.add(Student.builder().name("Rex").city("US").build());
		students.add(Student.builder().name("Doremon").city("China").build());
		students.add(Student.builder().name("chota bhim").city("India").build());
		students.add(Student.builder().name("Ash").city("Thailand").build());
		students.add(Student.builder().name("Popeye").city("Scotland").build());
		students.add(Student.builder().name("Shinchan").city("China").build());
		students.add(Student.builder().name("Johnny Bravo").city("US").build());
		students.add(Student.builder().name("Scooby Doo").city("US").build());
		students.add(Student.builder().name("Korra").city("China").build());
		students.add(Student.builder().name("Katara").city("China").build());
		students.add(Student.builder().name("Aang").city("China").build());
		students.add(Student.builder().name("SpongeBob").city("US").build());
		students.add(Student.builder().name("Tom").city("India").build());
		students.add(Student.builder().name("Jerry").city("India").build());
		students.add(Student.builder().name("Mickey Mouse").city("Thailand").build());
		students.add(Student.builder().name("Pooh").city("Thailand").build());

		studentRepository.saveAll(students);
	}
}
