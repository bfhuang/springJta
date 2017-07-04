package com.jpawithonetomanyrel.repository;

import com.jpawithonetomanyrel.model.Book;
import com.jpawithonetomanyrel.model.BookCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookCategoryRepository extends CrudRepository<BookCategory, Integer>  {

}