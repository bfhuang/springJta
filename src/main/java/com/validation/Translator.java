package com.validation;

/**
 * Created by bfhuang on 7/6/17.
 */
public class Translator {


    public static CustomerVO translateCustomerDOToCustomerVO(CustomerDO customer) {
        CustomerVO customerVO = new CustomerVO();
        customerVO.setLastName(customer.getLastName());
        customerVO.setFirstName(customer.getFirstName());
        customerVO.setAge(customer.getAge());
        customerVO.setId(customer.getId());
        return customerVO;
    }

    public static CustomerDO translateCustomerVOToCustomerDO(CustomerVO customer) {
        CustomerDO customerDO = new CustomerDO();
        customerDO.setAge(customer.getAge());
        customerDO.setFirstName(customer.getFirstName());
        customerDO.setLastName(customer.getLastName());
        return customerDO;
    }
}
