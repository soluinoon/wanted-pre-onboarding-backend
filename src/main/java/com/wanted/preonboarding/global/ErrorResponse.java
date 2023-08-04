package com.wanted.preonboarding.global;

import lombok.Getter;

@Getter
public class ErrorResponse {
    String code;
    String error;

    public ErrorResponse(String code, String error) {
        this.code = code;
        this.error = error;
    }
}
