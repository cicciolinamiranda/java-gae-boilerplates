package com.cloudsherpas.java.config;

/**
 * @author RMPader
 */

import com.cloudsherpas.java.api.endpoint.ToDoEndpoint;
import com.google.api.server.spi.guice.GuiceSystemServiceServletModule;
import com.google.inject.Provides;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.cfg.Environment;

import javax.inject.Singleton;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GuiceCloudEndpointModule extends GuiceSystemServiceServletModule {

    @Override
    protected void configureServlets() {
        Map<String, Object> p = new HashMap();
        p.put(Environment.DATASOURCE, datasource());
        JpaPersistModule jpm = new JpaPersistModule("persistenceUnit");
        jpm.properties(p);
        this.install(jpm);
        Set<Class<?>> serviceClasses = new HashSet<>();
        serviceClasses.add(ToDoEndpoint.class);

        this.filter("/*")
            .through(PersistFilter.class);
        this.serveGuiceSystemServiceServlet("/_ah/spi/*", serviceClasses);
    }

    @Provides
    @Singleton
    public DataSource datasource() {
        BasicDataSource datasource = new BasicDataSource();
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost/test?user=root");
        datasource.setUsername("root");
        datasource.setPassword("pass");
        datasource.setMaxActive(12);
        return datasource;
    }


}
