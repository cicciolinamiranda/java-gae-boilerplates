package com.cloudsherpas.java.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * @author RMPader
 */
public class ServletContextListener extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new GuiceCloudEndpointModule(), new DependencyModule());
    }
}
