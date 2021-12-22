package com.jackpan.spring.bean.configuration.methodinjectionn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MethodInjectionConfig {

    @Bean
    @Scope("prototype")
    public Command asyncCommand() {
        AsyncCommand asyncCommand = new AsyncCommand();
        return asyncCommand;
    }

    @Bean
    public CommandManager commandManager() {
        // return new anonymous implementation of CommandManager with createCommand()
        // overridden to return a new prototype Command object
        return new CommandManager() {
            protected Command createCommand() {
                return asyncCommand();
            }
        };
    }
}
