package com.wanted.preonboarding.global.security;

import com.wanted.preonboarding.member.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Access;

@Getter
@AllArgsConstructor
@Builder
public class TokenDto {
    private Role role;
    private String accessToken;
    private String refreshToken;
}


