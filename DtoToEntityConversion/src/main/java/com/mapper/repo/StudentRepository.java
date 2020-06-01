package com.mapper.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapper.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
