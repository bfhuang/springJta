package com.twodb;

import com.primarydb.Customer;
import com.seconddb.SecondCustomer;

/**
 * Created by bfhuang on 7/6/17.
 */

public class Translator {

    public static SecondCustomer translateToSecondCustomer(CustomerVO customerVO){
        SecondCustomer secondCustomer = new SecondCustomer(customerVO.getFirstName(), customerVO.getLastName());
        secondCustomer.setAge(customerVO.getAge());

        secondCustomer.setId(customerVO.getId());

        return secondCustomer;
    }

    public static CustomerVO translateToCustomerVo(SecondCustomer secondCustomer){
        CustomerVO customerVO = new CustomerVO();
        customerVO.setFirstName(secondCustomer.getFirstName());
        customerVO.setLastName(secondCustomer.getLastName());
        customerVO.setAge(secondCustomer.getAge());
        customerVO.setId(secondCustomer.getId());

        return customerVO;
    }


    public static CustomerVO translateToCustomerVo(Customer customer){
        CustomerVO customerVO = new CustomerVO();
        customerVO.setFirstName(customer.getFirstName());
        customerVO.setLastName(customer.getLastName());
        customerVO.setAge(customer.getAge());
        customerVO.setId(customer.getId());

        return customerVO;
    }

    public static Customer translateToCustomer(CustomerVO customerVO){
        Customer customer = new Customer(customerVO.getFirstName(), customerVO.getLastName());

        customer.setAge(customerVO.getAge());

        customer.setId(customerVO.getId());

        return customer;
    }


}
