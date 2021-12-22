package com.jackpan.spring.ioc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtherConfig {


    @Bean
    public StuffService stuffService() {
        return new StuffService();
    }
}
