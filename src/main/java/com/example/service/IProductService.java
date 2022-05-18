package com.example.service;

import java.util.List;

import com.example.model.Product;

public interface IProductService {

    Product saveOrUpdate(Product product);

    List<Product> getAllProducts();

    Product getProductById(int id);

    void deleteProduct(int id);

}
