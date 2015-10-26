package com.cloudsherpas.java.config;

import com.google.inject.AbstractModule;

/**
 * @author RMPader
 */
public class DependencyModule extends AbstractModule {

    @Override
    protected void configure() {
        //Bind un-managed beans here (i.e. classes that cannot be annotated with @Singleton)
    }
}
