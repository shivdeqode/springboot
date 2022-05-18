package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Document(collection = "product")
public class Product {
    
    @Id
    private int id;
    private String productName;
    private String productType;
}
