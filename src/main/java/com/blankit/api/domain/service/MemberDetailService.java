package com.blankit.api.domain.service;

import com.blankit.api.domain.entity.Member;
import com.blankit.api.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MemberDetailService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = memberRepository.findByNickname(username);
        if (member == null) {
            return new User("fail", "fail", new ArrayList<>());
        }
        return new User(username, member.getPassword(),new ArrayList<>());
    }
}
