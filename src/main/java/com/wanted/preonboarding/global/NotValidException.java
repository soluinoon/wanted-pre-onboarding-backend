package com.wanted.preonboarding.global;

public class NotValidException extends RuntimeException {
    private final String code;
    private final String message;

    public NotValidException(final String code, final String message) {
        this.code = code;
        this.message = message;
    }
}
