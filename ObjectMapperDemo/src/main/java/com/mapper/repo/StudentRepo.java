package com.mapper.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapper.domain.Student;

public interface StudentRepo  extends JpaRepository<Student, Long>{

}
