package com.example.springsecurityoauth2example.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class TokenSetting {

    @Bean
    public TokenSettings tokenSettings() {
        return TokenSettings.builder()
                .build();
    }
}
