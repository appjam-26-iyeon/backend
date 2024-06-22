package com.geunoo.backend.global.error.exceptions;


import com.geunoo.backend.global.error.CustomException;

public class InternalServerErrorException extends CustomException {
    public InternalServerErrorException() {
        super("Internal Server Error", 500);
    }
}
