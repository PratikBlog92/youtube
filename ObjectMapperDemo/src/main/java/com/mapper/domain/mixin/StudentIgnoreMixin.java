package com.mapper.domain.mixin;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mapper.domain.Address;
import com.mapper.domain.Hobby;

public abstract class StudentIgnoreMixin {

	@JsonIgnore
	public abstract String getPassword();
	
	@JsonIgnore
	public abstract List<Address> getAddress();

	@JsonIgnore
	public abstract List<Hobby> getHobbies();
	
}
