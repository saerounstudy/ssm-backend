package com.ssm.backend.global.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordHandler {
    private final BCryptPasswordEncoder passwordEncoder;

    public PasswordHandler() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String hash(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}