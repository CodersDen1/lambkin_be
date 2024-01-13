package com.example.lambkin_be.Security;

import com.example.lambkin_be.Users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

    private final JWTAuthenticationFilter jwtAuthenticationFilter;
    private final JWTService jwtService;
    private final UsersService usersService;

    @Autowired
    public AppSecurityConfig(JWTAuthenticationFilter jwtAuthenticationFilter, JWTService jwtService, UsersService usersService1) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.jwtService = jwtService;
        this.usersService = usersService1;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf((csrf)-> csrf.disable())
                .authorizeHttpRequests((authorizeHttpRequest)-> authorizeHttpRequest
                        .requestMatchers(HttpMethod.POST,"/**" ).permitAll()
                        .requestMatchers(HttpMethod.GET,"/**").permitAll()
                        .anyRequest().anonymous()
                ).formLogin(Customizer.withDefaults());
        http.addFilterBefore(jwtAuthenticationFilter, AnonymousAuthenticationFilter.class);

        return http.build();
    }

}
