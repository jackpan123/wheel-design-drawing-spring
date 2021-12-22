package com.jackpan.spring.bean.configuration.declarebean;

import org.springframework.context.annotation.Bean;

public interface BaseConfig {

    @Bean
    default TransferServiceImpl transferService() {
        return new TransferServiceImpl();
    }
}
