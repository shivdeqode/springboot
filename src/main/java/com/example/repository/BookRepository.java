package com.example.repository;

import java.util.List;

import com.example.model.Book;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {

    @Query("{'title': {$regex : '^A.*'} }")
    public List<Book> AuthorsNameStartingWithA();

    @Query("{'title': {$regex : '^U.*'} }")
    public List<Book> AuthorsNameStartingWithU();
}
