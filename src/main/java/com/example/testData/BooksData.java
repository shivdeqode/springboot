package com.example.testData;

import java.util.List;

import javax.annotation.PostConstruct;

import com.example.model.Book;
import com.example.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BooksData {

    @Autowired
    private BookRepository bookRepository;

    public BooksData(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void CreateTestData() {
        bookRepository.deleteAll();
        bookRepository.saveAll(
                List.of(

                        new Book(1, "Unfinished", "Priyanka chopra"),
                        new Book(2, "Time Machine", "H.G. Wells"),
                        new Book(3, "Antony and Cleopatra", "Shakespeare"),
                        new Book(4, "Origin of Species", "Charles Darwin"),
                        new Book(5, "Das Kapital", "Karl Marx"),
                        new Book(6, "Around the World in eighty days", "Jules Verne"),
                        new Book(7, "Agni", "A.P.J. Abdul Kalam"),
                        new Book(8, "Unaware", "Amber")

                ));

    }

}
