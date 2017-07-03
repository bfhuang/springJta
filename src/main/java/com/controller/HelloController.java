package com.controller;

import com.property.FooProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private FooProperties properties;

    @RequestMapping("/controller")
    public FooProperties home() {
        logger.info("controller controller begin");
        logger.debug("controller controller begin");

        return properties;
    }


    @RequestMapping("/exception")
    public void error() throws SomeException {
        throw new SomeException("exception happened");
    }


    public FooProperties getProperties() {
        return properties;
    }

    public void setProperties(FooProperties properties) {
        this.properties = properties;
    }
}