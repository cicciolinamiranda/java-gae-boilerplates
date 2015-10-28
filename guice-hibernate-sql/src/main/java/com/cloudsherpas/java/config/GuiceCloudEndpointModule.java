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
import java.io.IOException;
import java.util.*;

public class GuiceCloudEndpointModule extends GuiceSystemServiceServletModule {

    @Override
    protected void configureServlets() {
        try {
            Properties properties = properties();
            BasicDataSource datasource = new BasicDataSource();
            datasource.setDriverClassName(properties.getProperty("datasource.driver-class-name"));
            datasource.setUrl(properties.getProperty("datasource.url"));
            datasource.setUsername(properties.getProperty("datasource.username"));
            datasource.setPassword(properties.getProperty("datasource.password"));
            datasource.setMaxActive(12);

            Map<String, Object> p = new HashMap();
            p.put(Environment.DATASOURCE, datasource);
            JpaPersistModule jpm = new JpaPersistModule("persistenceUnit");
            jpm.properties(p);
            this.install(jpm);
            Set<Class<?>> serviceClasses = new HashSet<>();
            serviceClasses.add(ToDoEndpoint.class);

            this.filter("/*")
                .through(PersistFilter.class);
            this.serveGuiceSystemServiceServlet("/_ah/spi/*", serviceClasses);
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    @Provides
    @Singleton
    public Properties properties() throws IOException {
        Properties prop = new Properties();
        prop.load(this.getClass()
                      .getClassLoader()
                      .getResourceAsStream("application.properties"));
        return prop;
    }
}
