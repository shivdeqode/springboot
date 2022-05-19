package com.example.testData;

import java.util.List;

import javax.annotation.PostConstruct;

import com.example.model.Book;
import com.example.model.Publisher;
import com.example.repository.BookRepository;
import com.example.repository.PublisherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Publishers {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookRepository bookRepository;

    public Publishers(PublisherRepository publisherRepository, BookRepository bookRepository) {
        this.publisherRepository = publisherRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void CreateTestData() {
        // List<Book> authorWA = bookRepository.AuthorsNameStartingWithA();
        // List<Book> authorWU = bookRepository.AuthorsNameStartingWithU();

        // List<Book> BioGraphy = List.of(
        // new Book(1, "Unfinished", "Priyanka chopra"),
        // new Book(2, "Time Machine", "H.G. Wells"),
        // new Book(3, "Antony and Cleopatra", "Shakespeare"));

        // List<Book> HumanExistence = List.of(
        // new Book(4, "Origin of Species", "Charles Darwin"),
        // new Book(5, "Das Kapital", "Karl Marx"),
        // new Book(6, "Around the World in eighty days", "Jules Verne"),
        // new Book(7, "Agni", "A.P.J. Abdul Kalam"));

        // Now after adding DBRef

        List<Book> authorWA = bookRepository.AuthorsNameStartingWithA();
        List<Book> authorWU = bookRepository.AuthorsNameStartingWithU();

        publisherRepository.deleteAll();
        publisherRepository.saveAll(
                List.of(
                        // by this way they had and _id
                        // new Publisher(1, 196, "2018-09-09", authorWA),
                        // new Publisher(2, 196, "2019-09-09", authorWU),
                        // new Publisher(3, 196, "2020-09-09", authorWA),
                        // new Publisher(4, 196, "2021-09-09", authorWU)

                        // new Publisher(1, 196, "2018-09-09", BioGraphy),
                        // new Publisher(2, 196, "2019-09-09", HumanExistence),
                        // new Publisher(3, 196, "2020-09-09", BioGraphy),
                        // new Publisher(4, 196, "2021-09-09", HumanExistence))

                        new Publisher(1, 196, "2018-09-09", authorWA),
                        new Publisher(2, 196, "2019-09-09", authorWU),
                        new Publisher(3, 196, "2020-09-09", authorWA),
                        new Publisher(4, 196, "2021-09-09", authorWU)));

    }
}
