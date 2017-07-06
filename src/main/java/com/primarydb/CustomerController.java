package com.primarydb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/primarydb")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);


    @Autowired
    CustomerRepository repository;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public Page<Customer> getAllCustomers(@RequestParam(value = "page", required = false) int page,
                                          @RequestParam(value = "size", required = false) int size) {
        return repository.findAll(new PageRequest(page, size));
    }


    @RequestMapping(value = "/customers/customer", method = RequestMethod.POST)
    public Customer save(@RequestBody Customer customer) {
        Customer save = repository.save(customer);
        return save;
    }


    @RequestMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable("id") Long id) {
        return repository.findOne(id);
    }
}