package com.wanted.preonboarding.member.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
public class SignUpRequest {
    @Email
    private String email;

    @Size(min = 8)
    private String password;
}
