package com.cloudsherpas.java.config;

import com.cloudsherpas.java.config.property.DatabaseConfigurationProperties;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories("com.cloudsherpas.java.data.repository")
@EnableTransactionManagement
public class DatabaseConfiguration {

    @Autowired
    private DatabaseConfigurationProperties properties;

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        Properties props = new Properties();
        props.put("hibernate.hbm2ddl.auto", "auto");
        props.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setDataSource(dataSource());
        factory.setPersistenceUnitName("defaultPersistenceUnit");
        factory.setPackagesToScan("com.cloudsherpas.java.data.domain");
        factory.setJpaProperties(props);
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

    /*
     * (non-javadoc)
     * 
     * Use Tomcat 7 DBCP because GAE restricts usage on
     * java.lang.management.ManagementFactory
     */
    @Bean
    public DataSource dataSource() {
        BasicDataSource datasource = new BasicDataSource();
        datasource.setDriverClassName(properties.getDriverClassName());
        datasource.setUrl(properties.getUrl());
        datasource.setUsername(properties.getUsername());
        datasource.setPassword(properties.getPassword());
        datasource.setMaxActive(12);
        return datasource;
    }

}
