package com.search.filter.Controller;

import com.search.filter.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {

   //select & from student where name = 'pratik'
   Student findByName(String name);


   List<Student> findByAddressCity(String city);

   List<Student> findBySubjectsName(String subName);
}
