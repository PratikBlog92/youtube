package com.code.with.pratik.pagination.controller;

import com.code.with.pratik.pagination.domain.Student;
import com.code.with.pratik.pagination.dto.PageRequestDto;
import com.code.with.pratik.pagination.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public Page<Student> getAllStudentUsingPagination(@RequestBody PageRequestDto dto)
    {
        Pageable pageable = new PageRequestDto().getPageable(dto);
        Page<Student> studentPage = studentRepository.findAll(pageable);
        return  studentPage;
    }


}
