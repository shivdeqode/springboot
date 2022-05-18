package com.example.dto;

import java.util.List;

import com.example.model.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
public class ProductDTO {

    @JsonInclude(Include.NON_NULL)
    private List<Product> product;
    @JsonInclude(Include.NON_NULL)
    private String message;

}
