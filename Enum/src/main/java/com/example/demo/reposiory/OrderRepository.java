package com.example.demo.reposiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.RestorentOrder;

public interface OrderRepository extends JpaRepository<RestorentOrder, Long>{

}
