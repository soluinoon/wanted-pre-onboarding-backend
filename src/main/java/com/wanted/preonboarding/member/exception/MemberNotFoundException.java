package com.wanted.preonboarding.member.exception;

import com.wanted.preonboarding.global.NotFoundException;

public class MemberNotFoundException extends NotFoundException {
    private static final String ERROR_CODE = "MEMBER_DUPLICATED_ERROR";
    private static final String ERROR_MESSAGE = "없는 멤버 입니다.";

    public MemberNotFoundException(String email) {
        super(ERROR_CODE, String.format("%s : %s", ERROR_MESSAGE, email));
    }
}
