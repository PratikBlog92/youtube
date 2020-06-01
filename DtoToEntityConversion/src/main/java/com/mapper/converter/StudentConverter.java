package com.mapper.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.mapper.dto.StudentDto;
import com.mapper.entity.Student;

@Component
public class StudentConverter {
	
	public StudentDto entityToDto(Student student) {
		
		StudentDto dto = new StudentDto();
		dto.setId(student.getId());
		dto.setName(student.getName());
		dto.setUsename(student.getUsername());
		dto.setPassword(student.getPassword());
		
		return dto;
	}
	public  List<StudentDto> entityToDto(List<Student> student) {
		
		return	student.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
		
	}
	
	
	public Student dtoToEntity(StudentDto dto)
	{
		Student st = new Student();
		st.setId(dto.getId());
		st.setName(dto.getName());
		st.setPassword(dto.getPassword());
		st.setUsername(dto.getUsename());
		
		return st;
	}
	
	public List<Student> dtoToEntity(List<StudentDto> dto)
	{

		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

}
