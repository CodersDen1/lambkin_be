package com.example.lambkin_be.Security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
public class JWTAuthenticationFilter extends AuthenticationFilter {

    private JWTAuthenticationManager jwtAuthenticationManager;
    public JWTAuthenticationFilter(JWTAuthenticationManager jwtAuthenticationManager) {
        super(jwtAuthenticationManager , new JWTAuthenticationConverter());

        this.setSuccessHandler((request,response,authentication)->{
            SecurityContextHolder.getContext().setAuthentication(authentication);
        });
    }
}
