package com.wanted.preonboarding.member.service;

import com.wanted.preonboarding.member.domain.Member;
import com.wanted.preonboarding.member.dto.request.SignUpRequest;
import com.wanted.preonboarding.member.dto.response.SignUpResponse;
import com.wanted.preonboarding.member.exception.MemberDuplicatedException;
import com.wanted.preonboarding.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    public SignUpResponse save(final SignUpRequest signUpRequest) {
        validateDuplicatedMember(signUpRequest.getEmail());

        Member member = new Member(signUpRequest.getEmail(), signUpRequest.getPassword());

        memberRepository.save(member);
        log.info("Member saved '{}'", member.getEmail());

        return new SignUpResponse(true, member.getEmail());
    }

    private void validateDuplicatedMember(final String email) {
        if (memberRepository.existsByEmail(email)) {
            throw new MemberDuplicatedException(email);
        }
    }
}