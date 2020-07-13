package com.db.redis.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.db.redis.entity.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, String>{

}
