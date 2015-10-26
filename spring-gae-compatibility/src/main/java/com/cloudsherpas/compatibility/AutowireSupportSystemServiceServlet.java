package com.cloudsherpas.compatibility;

import com.google.api.server.spi.SystemServiceServlet;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class AutowireSupportSystemServiceServlet extends SystemServiceServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected <T> T createService(Class<T> arg0) {
        T service = super.createService(arg0);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(service, getServletContext());
        return service;
    }
}
