package com.example.albumviewerangularspring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*") // Allows all origins
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allows all HTTP methods
                .allowedHeaders("*") // Allows all headers
                .allowCredentials(true); // Allows cookies to be included in the request
    }
}
