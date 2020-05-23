package com.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.entity.booleanTest.BooleeanTest;

public interface BooleanRepository extends JpaRepository<BooleeanTest, Long>{

}
