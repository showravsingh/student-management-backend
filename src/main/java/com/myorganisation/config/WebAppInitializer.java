package com.myorganisation.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class, JpaConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet("smsDispatcher", dispatcherServlet);


        if (registration == null) {
            throw new IllegalStateException("Servlet 'dispatcher' could not be registered. Possibly already defined or invalid context.");
        }

        registration.setLoadOnStartup(1);
        registration.addMapping("/");

        registration.setInitParameter("encoding", "UTF-8");
    }
}
