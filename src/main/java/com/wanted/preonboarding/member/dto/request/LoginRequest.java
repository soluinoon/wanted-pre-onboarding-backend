package com.wanted.preonboarding.member.dto.request;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
public class LoginRequest {
    @Email
    private final String email;

    @Size(min = 8)
    private final String password;

    public LoginRequest(final String email, final String password) {
        this.email = email;
        this.password = password;
    }
}
