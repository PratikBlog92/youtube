package com.db.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.redis.entity.Book;
import com.db.redis.repo.BookRepo;

@RestController
public class TestController {

	@Autowired private BookRepo repo;
	
	@GetMapping("/test")
	@Cacheable(value= "allBookCache")
	public List<Book> getbooks(){
		return repo.findAll();
	}
	
	@PostMapping("/save")
	@CachePut(value= "bookCache", key= "#b.id")
	public Book save(@RequestBody Book b) {
		return repo.save(b);
	}
}
