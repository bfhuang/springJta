package com.jpawithonetomanyrel.controller;

import com.controller.SomeException;
import com.jpawithonetomanyrel.model.Book;
import com.jpawithonetomanyrel.model.BookCategory;
import com.jpawithonetomanyrel.repository.BookCategoryRepository;
import com.jpawithonetomanyrel.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
public class CategoryController {
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);


    @Autowired
    BookCategoryRepository repository;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public Iterable<BookCategory> getAllCategories() throws SomeException {
        Iterable<BookCategory> all = repository.findAll();
//        for (BookCategory bookCategory : all) {
//            bookCategory.getBooks().stream().forEach(it->it.setBookCategory(null));
//        }
        return all;
    }

    @RequestMapping(value = "/categories/category", method = RequestMethod.POST)
    public BookCategory save(@RequestBody BookCategory category) {

//        BookCategory bookCategory = new BookCategory("category1");
//        HashSet<Book> books = new HashSet<>();
//        books.add(new Book("book1", bookCategory));
//        books.add(new Book("book2", bookCategory));
//        bookCategory.setBooks(books);
//
//        repository.save(bookCategory);
//
//        return null;


        for (Book book :category.getBooks() ) {
            book.setBookCategory(category);
        }

        BookCategory save = repository.save(category);
        return save;

    }
}