package com.code.with.pratik.pagination.controller;

import com.code.with.pratik.pagination.domain.Student;
import com.code.with.pratik.pagination.dto.PageRequestDto;
import com.code.with.pratik.pagination.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.beans.support.SortDefinition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
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

    @PostMapping("/list")
    public Page<Student> getAllStudentUsingPaginationList(@RequestBody PageRequestDto dto)
    {

        List<Student> studentList = studentRepository.findAll();

        // 1. PageListHolder
        PagedListHolder<Student> pagedListHolder = new PagedListHolder<Student>(studentList);
        pagedListHolder.setPage(dto.getPageNo());
        pagedListHolder.setPageSize(dto.getPageSize());

        //2. PropertyComparator
        List<Student> pageSlice = pagedListHolder.getPageList();
        boolean ascending = dto.getSort().isAscending();
        PropertyComparator.sort(pageSlice,new MutableSortDefinition(dto.getSortByColumn(),true, ascending));

        // 3. PageImpl
        Page<Student> students = new PageImpl<>(pageSlice, new PageRequestDto().getPageable(dto), studentList.size());
        return  students;
    }


}
