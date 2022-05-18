package com.example.service;

import java.util.List;

import com.example.exceptionHandler.ProductNotFoundException;
import com.example.model.Product;
import com.example.repository.ProductRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    private ProductRepository productRepo;

    @Override
    public Product saveOrUpdate(Product product) {
        log.info("Inside saveOrUpdate Product data {}", product);
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        log.info("Fetching all Product details");
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(int id) {
        log.info("Fetching Product data for id :{}", id);
        return productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product Not Found for the given ID:"));
    }

    @Override
    public void deleteProduct(int id) {
        log.info("Deleting Product data for id: {}", id);
        productRepo.deleteById(id);

    }

}
