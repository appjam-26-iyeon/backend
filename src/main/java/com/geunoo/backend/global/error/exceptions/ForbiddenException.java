package com.geunoo.backend.global.error.exceptions;

import com.geunoo.backend.global.error.CustomException;

public class ForbiddenException extends CustomException {
    public ForbiddenException(String message) {
        super(message, 403);
    }
}
