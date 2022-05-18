package com.example.dao;

import java.util.List;

import com.example.model.Product;

public interface IProductDao {

    Product saveOrUpdate(Product product);

    List<Product> getAllProducts();

    Product getProductById(int id);

    void deleteProduct(int id);
}
