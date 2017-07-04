package com.jpawithonetomanyrel.repository;

import com.jpa.model.Customer;
import com.jpawithonetomanyrel.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends CrudRepository<Book, Integer>  {

}