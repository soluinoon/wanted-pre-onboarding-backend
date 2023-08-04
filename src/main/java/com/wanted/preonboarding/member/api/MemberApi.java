package com.wanted.preonboarding.member.api;

import com.wanted.preonboarding.member.dto.request.SignUpRequest;
import com.wanted.preonboarding.member.dto.response.SignUpResponse;
import com.wanted.preonboarding.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberApi {

    private final MemberService memberService;

    @PostMapping
    public SignUpResponse signUp(final @RequestBody @Valid SignUpRequest signUpRequest) {
        return memberService.save(signUpRequest);
    }
}
