package com.eeit45team2.lungspringbootversion.backend.member.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

public class CustomOAuth2User implements OAuth2User {
    private OAuth2User oauth2User;

    public CustomOAuth2User(OAuth2User oauth2User, String oauth2ClientName) {
        this.oauth2User = oauth2User;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return oauth2User.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return oauth2User.getAuthorities();
    }

    @Override
    public String getName() {
        System.out.println(oauth2User.<String>getAttribute("email"));
        return oauth2User.getAttribute("name");
    }

    public String getEmail() {
        return oauth2User.<String>getAttribute("email");
    }

}
