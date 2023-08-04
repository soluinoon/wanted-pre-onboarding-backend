package com.wanted.preonboarding.member.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Getter
public class SignUpResponse {
    private boolean success;
    private String email;
}
