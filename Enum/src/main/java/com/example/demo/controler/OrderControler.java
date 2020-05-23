package com.example.demo.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.OrderStatus;
import com.example.demo.domain.RestorentOrder;
import com.example.demo.reposiory.OrderRepository;

@RestController
public class OrderControler {

	@Autowired private OrderRepository orderRepository;
	
	@PostMapping("/order/create")
	public void save(@RequestBody RestorentOrder order) {
		
		List<RestorentOrder> orders = new ArrayList<>();
		
		for(int i=0;i<=10000;i++)
		{
			RestorentOrder rs = new RestorentOrder();
			rs.setDish("Dish"+i);
			rs.setStatus(OrderStatus.PLACED);
			orders.add(rs);
		}
		
		
		
		orderRepository.saveAll(orders);
	}
	
}
