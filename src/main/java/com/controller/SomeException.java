package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by bfhuang on 7/3/17.
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SomeException extends Throwable {
    public SomeException(String message) {
        super(message);
    }
}
