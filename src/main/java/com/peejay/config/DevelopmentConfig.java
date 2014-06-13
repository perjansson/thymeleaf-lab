package com.peejay.config;

import com.peejay.config.environment.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevelopmentConfig implements EnvironmentConfig {

    @Override
    @Bean
    public Environment getEnvironment() {
        return new Environment("dev");
    }

}
