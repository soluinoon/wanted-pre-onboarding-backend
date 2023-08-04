package com.wanted.preonboarding.global;

import lombok.Getter;

@Getter
public class DuplicatedException extends RuntimeException {
    private final String code;
    private final String message;

    public DuplicatedException(final String code, final String message) {
        this.code = code;
        this.message = message;
    }
}
