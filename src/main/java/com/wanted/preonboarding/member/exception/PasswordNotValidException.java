package com.wanted.preonboarding.member.exception;

import com.wanted.preonboarding.global.NotValidException;

public class PasswordNotValidException extends NotValidException {
    private static final String ERROR_CODE = "INVALID_PASSWORD_ERROR";
    private static final String ERROR_MESSAGE = "패스워드가 일치하지 않습니다.";

    public PasswordNotValidException(String email) {
        super(ERROR_CODE, String.format("%s : %s", ERROR_MESSAGE, email));
    }
}
