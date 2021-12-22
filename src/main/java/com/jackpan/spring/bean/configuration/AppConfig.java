package com.jackpan.spring.bean.configuration;

import com.jackpan.spring.bean.configuration.declarebean.BaseConfig;
import com.jackpan.spring.bean.configuration.declarebean.TransferServiceImpl;
import com.jackpan.spring.bean.configuration.impl.MyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.jackpan")
public class AppConfig implements BaseConfig {

    @Bean(initMethod = "init", destroyMethod = "cleanup")
    public MyService myService() {
        return new MyServiceImpl();
    }

    @Bean
    public TransferServiceImpl transferService1(MyService myService) {
        TransferServiceImpl transferService = new TransferServiceImpl();
        transferService.setMyService(myService);
        return transferService;
    }
}
