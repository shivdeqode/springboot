package com.example.controller;

import java.util.List;

import com.example.model.Product;
import com.example.service.IProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private IProductService productService;

    @PostMapping("addProduct")
    public Product saveProduct(@RequestBody Product product) {
        log.info("Input JSON {}", product);
        return productService.saveOrUpdate(product);
    }

    @GetMapping("getAllProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("getproduct/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PutMapping("updateProduct/{id}")
    public Product updateProductById(@RequestBody Product product) {
        return productService.saveOrUpdate(product);
    }

    @DeleteMapping("deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id) {

        productService.getProductById(id);
        productService.deleteProduct(id);
        return "entryDeleted";

    }

}
