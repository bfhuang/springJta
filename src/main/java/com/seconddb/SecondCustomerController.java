package com.seconddb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seconddb")
public class SecondCustomerController {
    private static final Logger logger = LoggerFactory.getLogger(SecondCustomerController.class);


    @Autowired
    SecondCustomerRepository repository;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public Page<SecondCustomer> getAllCustomers(@RequestParam(value = "page", required = false) int page,
                                              @RequestParam(value = "size", required = false) int size)  {
        return repository.findAll(new PageRequest(page, size));
    }


    @RequestMapping(value = "/customers/customer", method = RequestMethod.POST)
    public SecondCustomer save(@RequestBody SecondCustomer customer) {
        SecondCustomer save = repository.save(customer);
        return save;
    }


    @RequestMapping("/customers/{id}")
    public SecondCustomer getCustomerById(@PathVariable("id") Long id){
       return repository.findOne(id) ;
    }
}