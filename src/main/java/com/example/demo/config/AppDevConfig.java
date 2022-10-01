package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

@Configuration
@PropertySource("classpath:myasmple.properties")
@ConfigurationProperties(prefix = "a")
@Data
public class AppDevConfig {
    private String b;
    private String c;
    private Integer d;

    private List<String> list;
    private Map<String, String> map;
    private Db db;
}
