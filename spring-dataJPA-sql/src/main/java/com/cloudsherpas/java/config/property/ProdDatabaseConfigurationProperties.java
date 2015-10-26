package com.cloudsherpas.java.config.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application-cloudsql.properties")
@Profile("prodsql")
public class ProdDatabaseConfigurationProperties extends DatabaseConfigurationProperties {

    @Autowired
    private Environment env;

    @Override
    protected Environment getEnv() {
        return env;
    }
}
