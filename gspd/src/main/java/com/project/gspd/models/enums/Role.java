package com.project.gspd.models.enums;


import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_TEACHER, ROLE_STUDENT, ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}