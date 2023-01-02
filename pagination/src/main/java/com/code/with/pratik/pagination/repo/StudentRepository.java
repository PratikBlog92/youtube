package com.code.with.pratik.pagination.repo;

import com.code.with.pratik.pagination.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query(value = "select * from student where city = :city",
            countQuery = "select count(*) from student where city = :city",
            nativeQuery = true)
    Page<Student> findAllByCity(@Param("city") String city, Pageable pageable);

}
