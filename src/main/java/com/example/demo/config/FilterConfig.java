package com.example.demo.config;

import com.example.demo.filter.RequestResponseLoggingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<RequestResponseLoggingFilter> requestResponseLoggingFilter() {

        FilterRegistrationBean<RequestResponseLoggingFilter> filterRegistrationBean
                = new FilterRegistrationBean<RequestResponseLoggingFilter>();

        filterRegistrationBean.setFilter(new RequestResponseLoggingFilter());
        filterRegistrationBean.addUrlPatterns("/employees");
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }

}
