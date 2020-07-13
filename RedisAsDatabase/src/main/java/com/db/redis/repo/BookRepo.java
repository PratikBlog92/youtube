package com.db.redis.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.redis.entity.Book;

public interface BookRepo extends JpaRepository<Book, Long>{

}
