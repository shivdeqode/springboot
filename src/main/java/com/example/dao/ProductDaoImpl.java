package com.example.dao;

import java.util.List;

import com.example.model.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements IProductDao {

    private final Logger log = LoggerFactory.getLogger(ProductDaoImpl.class);

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Product saveOrUpdate(Product product) {
        log.info("Inside saveOrUpdate Product data {}", product);
        return mongoTemplate.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        log.info("Fetching all Product details");
        return mongoTemplate.findAll(Product.class);
    }

    @Override
    public Product getProductById(int id) {
        log.info("Fetching Product data for id :{}", id);
        return mongoTemplate.findById(id, Product.class);
    }

    @Override
    public void deleteProduct(int id) {
        log.info("Deleting Product data for id: {}", id);
        Product product = mongoTemplate.findById(id, Product.class);
        mongoTemplate.remove(product);
    }

}
