package com.validation;

/**
 * Created by bfhuang on 7/6/17.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CustomerValidator implements Validator {
    @Autowired
    private CustomerDORepository repository;


    @Override
    public boolean supports(Class<?> clazz) {
        return CustomerVO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerVO customerVO = (CustomerVO) target;

        if (repository.exists(customerVO.getId())) {
            errors.rejectValue("id", "customer with given id already exist" );
        }
    }
}