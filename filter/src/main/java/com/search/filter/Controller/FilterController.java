package com.search.filter.Controller;

import com.search.filter.domain.Student;
import com.search.filter.dto.RequestDto;
import com.search.filter.service.FiltersSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@RestController
@RequestMapping("/filter")
public class FilterController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private FiltersSpecification<Student> studentFiltersSpecification;

    @GetMapping("/{name}")
    public Student getStdByName(@PathVariable(name = "name") String name) {

        return studentRepository.findByName(name);
    }

    @GetMapping("/city/{CITY}")
    public List<Student> getStdByCity(@PathVariable(name = "CITY") String city) {

        return studentRepository.findByAddressCity(city);
    }

    @GetMapping("/subject/{SUB}")
    public List<Student> getStdBySubject(@PathVariable(name = "SUB") String subject) {

        return studentRepository.findBySubjectsName(subject);
    }

//    @PostMapping("/specification")
//    public List<Student> getStudents() {
//        Specification<Student> specification = new Specification<Student>() {
//
//            @Override
//            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//                return criteriaBuilder.equal(root.get("id"), "3");
//            }
//        };
//        List<Student> all = studentRepository.findAll(specification);
//        return all;
//    }


    @PostMapping("/specification")
    public List<Student> getStudents(@RequestBody RequestDto requestDto) {
        Specification<Student> searchSpecification = studentFiltersSpecification
                .getSearchSpecification(requestDto.getSearchRequestDto(), requestDto.getGlobalOperator());
        return studentRepository.findAll(searchSpecification);
    }



}
