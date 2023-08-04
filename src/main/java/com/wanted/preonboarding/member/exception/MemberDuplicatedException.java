package com.wanted.preonboarding.member.exception;

import com.wanted.preonboarding.global.DuplicatedException;

public class MemberDuplicatedException extends DuplicatedException {
    private static final String ERROR_CODE = "MEMBER_DUPLICATED_ERROR";
    private static final String ERROR_MESSAGE = "이미 존재하는 멤버입니다.";

    public MemberDuplicatedException(String email) {
        super(ERROR_CODE, String.format("%s : %s", ERROR_MESSAGE, email));
    }
}
