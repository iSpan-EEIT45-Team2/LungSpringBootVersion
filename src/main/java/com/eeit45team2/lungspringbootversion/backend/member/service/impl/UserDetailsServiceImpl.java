package com.eeit45team2.lungspringbootversion.backend.member.service.impl;

import com.eeit45team2.lungspringbootversion.backend.member.model.MemberBean;
import com.eeit45team2.lungspringbootversion.backend.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private MemberService memberService;

    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String miAccount)
            throws UsernameNotFoundException {
        MemberBean member = memberService.findByMiAccount(miAccount);
        System.out.println("member : "+member);
        if(member==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(member.getMiAccount(), member.getMiPassword(),
                true, true, true, true, getGrantedAuthorities(member));
    }


    private List<GrantedAuthority> getGrantedAuthorities(MemberBean member){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        authorities.add(new SimpleGrantedAuthority("ROLE_"+member.getType()));
        System.out.print("authorities :"+authorities);
        return authorities;
    }

}