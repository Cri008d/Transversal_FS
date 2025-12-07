package com.Plantita.Plantita_BackEnd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class Securityconfig {

    @Bean
    public PasswordEncoder PaswordEndcoder(){
        return new BCryptPasswordEncoder();
    }
}