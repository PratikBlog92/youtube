package com.cache.server.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cache.server.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
