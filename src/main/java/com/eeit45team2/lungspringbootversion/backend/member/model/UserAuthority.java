package com.eeit45team2.lungspringbootversion.backend.member.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

public enum UserAuthority {
    USER("USER"),EMPLOYEE("EMPLOYEE") , ADMIN("ADMIN");

    String UserAuthority;

    private UserAuthority(String UserAuthority){
        this.UserAuthority = UserAuthority;
    }

    public String getUserAuthority(){
        return UserAuthority;
    }

    @JsonCreator
    public UserAuthority fromString(String key) {
        return Arrays.stream(values())
                .filter(value -> value.name().equalsIgnoreCase(key))
                .findFirst()
                .orElse(null);
    }
}
