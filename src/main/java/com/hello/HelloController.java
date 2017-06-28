package com.hello;

import com.property.FooProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(Exception.class);

    @Autowired
    private FooProperties properties;

    @RequestMapping("/hello")
    public FooProperties home() {
        logger.info("hello controller begin");

        return properties;
    }

    public FooProperties getProperties() {
        return properties;
    }

    public void setProperties(FooProperties properties) {
        this.properties = properties;
    }
}