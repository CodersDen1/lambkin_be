package com.example.lambkin_be.Security;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public interface CorsConfigInterface extends WebMvcConfigurer {
    void addCorsMapping(CorsRegistry registry);
}

