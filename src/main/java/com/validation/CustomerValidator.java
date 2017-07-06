package com.validation;

/**
 * Created by bfhuang on 7/6/17.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CustomerValidator implements Validator {
    @Autowired
    private CustomerDORepository repository;

    @Autowired
    private AddressValidator addressValidator;


    @Override
    public boolean supports(Class<?> clazz) {
        return CustomerVO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerVO customerVO = (CustomerVO) target;

        if (repository.exists(customerVO.getId())) {
            errors.reject("error code", "customer with given id already exist");
        }
        if(customerVO.getAge()==0){
            errors.reject("error code", "age should not be 0");
        }

        try {
//            errors.pushNestedPath("address");
            ValidationUtils.invokeValidator(this.addressValidator, customerVO.getAddress(), errors);
        } finally {
//            errors.popNestedPath();
        }
    }
}