package com.cache.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cache.server.entity.Book;
import com.cache.server.repo.BookRepository;

@RestController
public class BookController {
	
	//1. for list of books = AllbookCache
	//2. entity of book = BookCache
	

	@Autowired
	private BookRepository repository;
	
	@GetMapping("/findAll")
	@Cacheable(value = "AllBookCache")
	public List<Book> findAll()
	{
      return repository.findAll();
	}
	
	@GetMapping("/findById/{ID}")
	@Cacheable(value = "BookCache")
	public Book getBookById(@PathVariable(value = "ID") Long id)
	{
      return repository.findById(id).orElse(null);
	}
	
	@PostMapping("/save")
	@Caching(
				put= {@CachePut(value = "BookCache", key = "#book.id")	},
				evict = {@CacheEvict(value = "AllbookCache")}
			)
	public Book save(@RequestBody Book book)
	{
      return repository.save(book);
	}
	
	
	@Caching(
			put= {@CachePut(value = "BookCache", key = "#book.id")	},
			evict = {@CacheEvict(value = "AllbookCache")}
		)
	@PostMapping("/update")
	public Book update(@RequestBody Book book)
	{
      return repository.save(book);
	}
	
	@GetMapping("/delete/{ID}")
	@Caching(
			evict = {
					@CacheEvict(value = "BookCache",key = "#id"),
					@CacheEvict(value = "AllbookCache")
			}
			)
	public void delete(@PathVariable(value = "ID") Long id)
	{
		Book book = repository.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
		repository.delete(book);
	}
	
}
