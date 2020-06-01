package com.example.demo.config;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.controller.NotFoundExeption;
import com.example.demo.dto.ErrorDto;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandlar {

	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<ErrorDto> generateException(ResponseStatusException re)
	{
		ErrorDto dto = new ErrorDto();
		dto.setTimestamp(new Date().toString());
		dto.setStatus( String.valueOf( re.getStatus().value()));
		dto.setErrorMessage(re.getMessage());
		log.error("Exception Occured : ",re);
		
		return new ResponseEntity<ErrorDto>(dto,re.getStatus());
	}
	
	@ExceptionHandler(NotFoundExeption.class)
	public ResponseEntity<ErrorDto> generateException(NotFoundExeption re)
	{
		ErrorDto dto = new ErrorDto();
		dto.setTimestamp(new Date().toString());
		dto.setStatus("404");
		dto.setErrorMessage(re.getMessage());
		log.error("Exception Occured : ",re);
		
		return new ResponseEntity<ErrorDto>(dto,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorDto> generateException(RuntimeException re)
	{
		ErrorDto dto = new ErrorDto();
		dto.setTimestamp(new Date().toString());
		dto.setStatus("500");
		dto.setErrorMessage(re.getMessage());
		log.error("Exception Occured : ",re);

		return new ResponseEntity<ErrorDto>(dto,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
