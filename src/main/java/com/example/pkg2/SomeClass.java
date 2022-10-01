package com.example.pkg2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SomeClass {

    @Bean
    public TestBean testBean() {
        return new TestBean();
    }
}
