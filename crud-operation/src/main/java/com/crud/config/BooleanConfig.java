package com.crud.config;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanConfig implements AttributeConverter<Boolean, String> {

	@Override
	public String convertToDatabaseColumn(Boolean b) {
		  if (b == null) {
	            return null;
	        }
	        if (b.booleanValue()) {
	            return "Y";
	        }
	        return "N";
	}

	@Override
	public Boolean convertToEntityAttribute(String s) {

		   if (s == null) {
	            return null;
	        }
	        if (s.equals("Y") || s.equals("y")) {
	            return Boolean.TRUE;
	        }
	        return Boolean.FALSE;
	    }
	}


