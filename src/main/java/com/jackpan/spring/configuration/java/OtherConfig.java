package com.jackpan.spring.configuration.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtherConfig {


    @Bean
    public StuffService stuffService() {
        return new StuffService();
    }
}
