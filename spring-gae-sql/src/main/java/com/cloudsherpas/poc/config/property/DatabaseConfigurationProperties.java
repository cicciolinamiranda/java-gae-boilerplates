package com.cloudsherpas.poc.config.property;

import org.springframework.core.env.Environment;

public abstract class DatabaseConfigurationProperties {


    public String getDriverClassName() {
        return getEnv().getProperty("spring.datasource.driver-class-name");
    }

    public String getUrl() {
        return getEnv().getProperty("spring.datasource.url");
    }

    public String getUsername() {
        return getEnv().getProperty("spring.datasource.username");
    }

    public String getPassword() {
        return getEnv().getProperty("spring.datasource.password");
    }
    
    protected abstract Environment getEnv();

}
