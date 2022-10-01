package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties(prefix = "welcome")
@Data
public class EnvProfileConfiguration {

    private String message;

    @Profile("dev")
    @Bean
    public String devBean() {
        return "dev";
    }

    @Profile("qa")
    @Bean
    public String qaBean() {
        return "qa";
    }

    @Profile("prod")
    @Bean
    public String prodBean() {
        return "prod";
    }
}
