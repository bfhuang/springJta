package com.validation;

/**
 * Created by bfhuang on 7/6/17.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AddressValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return AddressVO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AddressVO addressVO = (AddressVO) target;

        if( addressVO.getLine1()==null || addressVO.getLine1().isEmpty()){
            errors.reject("error code", "address line 1 should not not be blank");
        }
    }
}