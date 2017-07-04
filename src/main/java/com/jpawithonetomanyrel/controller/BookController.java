package com.jpawithonetomanyrel.controller;

import com.controller.SomeException;
import com.jpa.model.Customer;
import com.jpa.repository.CustomerRepository;
import com.jpawithonetomanyrel.model.Book;
import com.jpawithonetomanyrel.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);


    @Autowired
    BookRepository repository;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public Iterable<Book> getAllBooks() throws SomeException {
        return repository.findAll();
    }

    @RequestMapping(value = "/books/book", method = RequestMethod.POST)
    public Book save(@RequestBody Book book) {
        Book save = repository.save(book);
        return save;
    }
}