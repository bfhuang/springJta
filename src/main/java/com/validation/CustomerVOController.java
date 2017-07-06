package com.validation;

import com.controller.SomeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static com.validation.Translator.translateCustomerDOToCustomerVO;
import static com.validation.Translator.translateCustomerVOToCustomerDO;

@RestController
@RequestMapping("/validation/customers")
public class CustomerVOController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerVOController.class);


    @Autowired
    CustomerDORepository repository;


    @Autowired
    CustomerValidator validator;

    @InitBinder
    public void setupBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }


    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public ResponseEntity save(@Valid @RequestBody CustomerVO customer) {
//        if(errors.hasErrors()){
//            String result = errors.getAllErrors().stream().map(error -> error.getDefaultMessage())
//                    .collect(Collectors.joining(","));
//            return ResponseEntity.badRequest().body(result);
//        }


        CustomerDO save = repository.save(translateCustomerVOToCustomerDO(customer));
        return ResponseEntity.ok().body(translateCustomerDOToCustomerVO(save));
    }



    @RequestMapping("/{id}")
    public CustomerDO getCustomerById(@PathVariable("id") Long id){
       return repository.findOne(id) ;
    }
}