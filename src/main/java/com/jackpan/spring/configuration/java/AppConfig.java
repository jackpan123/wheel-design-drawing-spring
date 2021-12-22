package com.jackpan.spring.configuration.java;

import com.jackpan.spring.configuration.java.declarebean.BaseConfig;
import com.jackpan.spring.configuration.java.impl.MyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.jackpan")
public class AppConfig implements BaseConfig {

    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
}
