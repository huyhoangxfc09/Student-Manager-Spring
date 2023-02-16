package com.example.student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc // cho phép sử dụng MVC và thư viện của nó
@Configuration // đánh dấu đây là một file config
@ComponentScan ("com.example.student")
// Đánh dầu nơi IoC Container quét qua để khởi tạo các bean
public class AppConfig implements WebMvcConfigurer {
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        // Đặt tiền tố:
        viewResolver.setPrefix("/WEB-INF/");
        // Đặt hậu tố
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
