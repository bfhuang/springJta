package com.jpa.repository;

import java.awt.print.Pageable;
import java.util.List;

import com.jpa.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> , PagingAndSortingRepository<Customer, Long> {

    List<Customer> readByLastName(String lastName);


//    @Query("select * from customer where firstName = ?1")
    List<Customer> getByFirstName(String firstName);

//    Page<Customer> findAll(Pageable page);

//    @Query("select * from customer where id = ?1")
//    Customer find(@Param("id")Long id);
}