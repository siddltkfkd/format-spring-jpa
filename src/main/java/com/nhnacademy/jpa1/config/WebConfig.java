package com.nhnacademy.jpa1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
//@ComponentScan(basePackageClasses = )
public class WebConfig implements WebMvcConfigurer {
}
