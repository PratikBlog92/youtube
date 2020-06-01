package com.example.demo.dto;

import lombok.Data;

@Data
public class ErrorDto {
	
	private String timestamp;
	private String status;
	private String errorMessage;
	
}
