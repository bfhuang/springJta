package com.resttemplate;

import com.jpa.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bfhuang on 7/6/17.
 */
@RestController
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/resttemplate/customer")
    public Customer test() {
        return restTemplate.getForObject("http://localhost:8080/dev/customers/44521", Customer.class);
    }


    @RequestMapping("/resttemplate/customers")
    public List<Customer> test1() {

        Customer[] forObject = restTemplate.getForObject("http://localhost:8080/dev/customers/customer?firstName=firstName1", Customer[].class);
        return Arrays.asList(forObject);
    }

    @RequestMapping("/resttemplate/customers1")
    public List test2() {

        List forObject = restTemplate.getForObject("http://localhost:8080/dev/customers/customer?firstName=firstName1", List.class);
        return forObject;
    }


}
