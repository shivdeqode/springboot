package com.example.service;

import java.util.List;

import com.example.dao.IProductDao;
import com.example.model.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private IProductDao productDao;

    @Override
    public Product saveOrUpdate(Product product) {
        log.info("Inside saveOrUpdate Product data {}", product);
        return productDao.saveOrUpdate(product);
    }

    @Override
    public List<Product> getAllProducts() {
        log.info("Fetching all Product details");
        return productDao.getAllProducts();
    }

    @Override
    public Product getProductById(int id) {
        log.info("Fetching Product data for id :{}", id);
        return productDao.getProductById(id);
    }

    @Override
    public void deleteProduct(int id) {
        log.info("Deleting Product data for id: {}", id);
        productDao.deleteProduct(id);

    }

}
