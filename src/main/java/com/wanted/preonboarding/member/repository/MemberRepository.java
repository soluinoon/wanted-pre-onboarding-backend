package com.wanted.preonboarding.member.repository;

import com.wanted.preonboarding.member.domain.Member;
import com.wanted.preonboarding.member.exception.MemberNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsByEmail(String email);
    Optional<Member> findByEmail(String email);

    default Member getByEmail(String email) {
        return findByEmail(email).orElseThrow(() -> new MemberNotFoundException(email));
    }
}
