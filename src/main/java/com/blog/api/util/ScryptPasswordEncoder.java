package com.blog.api.util;

import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Profile("default")
@Component
public class ScryptPasswordEncoder implements PasswordEncoder {

    private final SCryptPasswordEncoder passwordEncoder;

    public ScryptPasswordEncoder() {
        this.passwordEncoder = new SCryptPasswordEncoder(16, 8, 1, 32, 64);
    }

    @Override
    public String getEncodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    @Override
    public Boolean isMatches(String rawPassword, String encodePassword) {
        return passwordEncoder.matches(rawPassword, encodePassword);
    }
}
