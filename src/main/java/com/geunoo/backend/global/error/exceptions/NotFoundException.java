package com.geunoo.backend.global.error.exceptions;


import com.geunoo.backend.global.error.CustomException;

public class NotFoundException extends CustomException {
    public NotFoundException(String message) {
        super(message, 404);
    }
}
