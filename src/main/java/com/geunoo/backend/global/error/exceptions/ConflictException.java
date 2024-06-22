package com.geunoo.backend.global.error.exceptions;


import com.geunoo.backend.global.error.CustomException;

public class ConflictException extends CustomException {
    public ConflictException(String message) {
        super(message, 409);
    }
}
