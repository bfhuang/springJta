package com.validation;

import com.jpa.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerDORepository extends CrudRepository<CustomerDO, Long> , PagingAndSortingRepository<CustomerDO, Long> {

    List<CustomerDO> readByLastName(String lastName);


    @Query("select c from Customer c where firstName = ?1")
    List<CustomerDO> getByFirstName(String firstName);

//    Page<Customer> findAll(Pageable page);

//    @Query("select * from customer where id = ?1")
//    Customer find(@Param("id")Long id);
}