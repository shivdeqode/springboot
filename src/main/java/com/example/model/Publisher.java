package com.example.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "Publisher")
public class Publisher {

    @Id
    private int id;
    private int pages;
    // @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String publishedYear;

    // Manual Reference can be added by
    // @DocumentReference
    // List<Book> books;
    // if same db no need to mention db
    // bydefault lazy loading
    @DBRef
    List<Book> books;
}
