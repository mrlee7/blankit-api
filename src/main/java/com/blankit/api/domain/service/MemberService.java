package com.blankit.api.domain.service;

import com.blankit.api.domain.entity.Member;
import com.blankit.api.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public Member get(Long memberId) throws Exception {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new Exception("member not found"));
    }

    @Transactional(readOnly = true)
    public Boolean exists(Long memberId) {
        return memberRepository.existsById(memberId);
    }

}
