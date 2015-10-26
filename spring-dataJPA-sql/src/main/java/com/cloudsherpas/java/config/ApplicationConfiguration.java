package com.cloudsherpas.java.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.cloudsherpas.java"})
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {

}
