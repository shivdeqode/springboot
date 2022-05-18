package com.example.repository;

import java.util.Optional;

import com.example.model.Product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {

   Optional<Product> findById(int id);

}
