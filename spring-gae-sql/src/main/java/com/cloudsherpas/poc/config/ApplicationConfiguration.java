package com.cloudsherpas.poc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = { "com.cloudsherpas.poc" })
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {

}
