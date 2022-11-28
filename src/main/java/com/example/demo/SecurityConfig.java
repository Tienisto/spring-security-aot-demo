package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final MyAuthenticationManager myAuthenticationManager;

    public SecurityConfig(MyAuthenticationManager myAuthenticationManager) {
        this.myAuthenticationManager = myAuthenticationManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authenticationManager(myAuthenticationManager);
        return http.build();
    }
}
