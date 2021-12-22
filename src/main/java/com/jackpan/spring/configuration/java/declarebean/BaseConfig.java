package com.jackpan.spring.configuration.java.declarebean;

import org.springframework.context.annotation.Bean;

public interface BaseConfig {

    @Bean
    default TransferServiceImpl transferService() {
        return new TransferServiceImpl();
    }
}
