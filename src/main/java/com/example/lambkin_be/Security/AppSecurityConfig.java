package com.example.lambkin_be.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf((csrf)-> csrf.disable())
                .authorizeHttpRequests((authorizeHttpRequest)-> authorizeHttpRequest
                        .requestMatchers(HttpMethod.POST,"/**" ).permitAll()
                        .requestMatchers(HttpMethod.GET,"/**").permitAll()
                        .anyRequest().anonymous()
                ).formLogin(Customizer.withDefaults());

        return http.build();
    }

}
