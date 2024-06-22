package com.geunoo.backend.global.error.exceptions;


import com.geunoo.backend.global.error.CustomException;

public class UnauthorizedException extends CustomException {
    public UnauthorizedException(String message) {
        super(message, 401);
    }
}
