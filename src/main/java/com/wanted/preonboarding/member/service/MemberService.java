package com.wanted.preonboarding.member.service;

import com.wanted.preonboarding.global.security.JwtTokenProvider;
import com.wanted.preonboarding.global.security.TokenDto;
import com.wanted.preonboarding.member.domain.Member;
import com.wanted.preonboarding.member.dto.request.LoginRequest;
import com.wanted.preonboarding.member.dto.request.SignUpRequest;
import com.wanted.preonboarding.member.dto.response.LoginResponse;
import com.wanted.preonboarding.member.dto.response.SignUpResponse;
import com.wanted.preonboarding.member.exception.MemberDuplicatedException;
import com.wanted.preonboarding.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public SignUpResponse save(final SignUpRequest signUpRequest) {
        validateDuplicatedMember(signUpRequest.getEmail());

        String encodedPassword = passwordEncoder.encode(signUpRequest.getPassword());
        Member member = new Member(signUpRequest.getEmail(), encodedPassword);

        memberRepository.save(member);
        log.info("Member saved '{}'", member.getEmail());

        return new SignUpResponse(true, member.getEmail());
    }

    private void validateDuplicatedMember(final String email) {
        if (memberRepository.existsByEmail(email)) {
            throw new MemberDuplicatedException(email);
        }
    }

    public LoginResponse login(final LoginRequest loginRequest) {
        // 1. Login ID/PW 기반으로 Authentication 객체 생성
        // 이 때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());

        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 메서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        // 3. Authentication 객체를 통해 Principal 얻기
        TokenDto tokenDto = jwtTokenProvider.generateToken(authentication);

        return new LoginResponse(tokenDto);
    }
}
