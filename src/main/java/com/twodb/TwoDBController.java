package com.twodb;

import com.primarydb.Customer;
import com.primarydb.CustomerRepository;
import com.seconddb.SecondCustomer;
import com.seconddb.SecondCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bfhuang on 7/6/17.
 */

@RestController
@RequestMapping("/twodb")
public class TwoDBController {

    @Autowired
    SecondCustomerRepository secondCustomerRepository;

    @Autowired
    CustomerRepository repository;

    @RequestMapping(value = "/customers/customer", method = RequestMethod.POST)
    @Transactional
    public List<CustomerVO> add(@RequestBody CustomerVO customerVO) {
        SecondCustomer secondCustomer =
                secondCustomerRepository.save(Translator.translateToSecondCustomer(customerVO));
        Customer customer = repository.save(Translator.translateToCustomer(customerVO));

        return Arrays.asList(Translator.translateToCustomerVo(customer),
                Translator.translateToCustomerVo(secondCustomer));
    }


}
