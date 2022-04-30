package com.blankit.api.domain.repository;

import com.blankit.api.domain.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired private MemberRepository memberRepository;

    @Test
    void save_test() {
        // given
        Member member = Member.builder()
                .email("test1@test")
                .nickname("test1")
                .build();

        // when
        memberRepository.save(member);

        // then
        assertThat(member.getId()).isNotNull();
    }

    @Test
    void find_all_test() {
        // given
        Member member = Member.builder()
                .email("test1@test")
                .nickname("test1")
                .build();
        memberRepository.save(member);

        // when
        Member find = memberRepository.findById(member.getId()).orElse(null);

        // then
        assertThat(member.getEmail()).isEqualTo("test1@test");
        assertThat(member.getNickname()).isEqualTo("test1");
    }


}