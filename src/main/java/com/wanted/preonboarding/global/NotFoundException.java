package com.wanted.preonboarding.global;

public class NotFoundException extends RuntimeException {
    private final String code;
    private final String message;

    public NotFoundException(final String code, final String message) {
        this.code = code;
        this.message = message;
    }
}
