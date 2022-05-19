package com.example.controller;

import java.util.List;

import com.example.dto.ProductDTO;
import com.example.exceptionHandler.ProductNotFoundException;
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

    // Method to save a Product
    @PostMapping("addProduct")
    public Product saveProduct(@RequestBody Product product) {
        log.info("Input JSON {}", product);
        return productService.saveOrUpdate(product);
    }

    // Method to get all list of products
    @GetMapping("getAllProducts")
    public ProductDTO getAllProducts() {
        ProductDTO productDTO = new ProductDTO();
        List<Product> product = productService.getAllProducts();
        if (product.isEmpty())
            productDTO.setMessage("No Records Found");
        else
            productDTO.setProduct(product);
        return productDTO;
    }

    // Method to get Product by id
    @GetMapping("getproduct/{id}")
    public Product getProductById(@PathVariable int id) {
        Product product = productService.getProductById(id);
        if (null != product) {
            return productService.getProductById(id);
        } else
            throw new ProductNotFoundException("Product Not Found for the given ID");

    }

    // Method to save or update product by id
    @PutMapping("updateProduct/{id}")
    public Product updateProductById(@RequestBody Product product) {
        return productService.saveOrUpdate(product);
    }

    // Method to delete product by id
    @DeleteMapping("deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id) {

        Product product = productService.getProductById(id);
        if (null != product) {
            productService.deleteProduct(id);
            return "entry Deleted";
        } else
            throw new ProductNotFoundException("Product Not Found for the given ID");

    }

}
