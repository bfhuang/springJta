package com.advice;

import org.springframework.util.MultiValueMap;

/**
 * Created by bfhuang on 7/3/17.
 */
public class CustomErrorType {
    private final int status;
    private final String message;

    public CustomErrorType(int status, String message) {
        this.status = status;
        this.message = message;
    }


    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
