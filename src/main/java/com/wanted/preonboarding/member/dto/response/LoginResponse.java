package com.wanted.preonboarding.member.dto.response;

import com.wanted.preonboarding.global.security.TokenDto;
import lombok.Getter;

@Getter
public class LoginResponse {
    private final String accessToken;
    private final String refreshToken;

    public LoginResponse(final TokenDto tokenDto) {
        this.accessToken = tokenDto.getAccessToken();
        this.refreshToken = tokenDto.getRefreshToken();
    }
}
