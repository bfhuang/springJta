package com.seconddb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SecondCustomerRepository extends CrudRepository<SecondCustomer, Long> , PagingAndSortingRepository<SecondCustomer, Long> {
}