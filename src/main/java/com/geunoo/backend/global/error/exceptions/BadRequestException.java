package com.geunoo.backend.global.error.exceptions;


import com.geunoo.backend.global.error.CustomException;

public class BadRequestException extends CustomException {
    public BadRequestException(String message) {
        super(message, 400);
    }
}
