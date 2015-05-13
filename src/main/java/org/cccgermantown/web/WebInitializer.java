package org.cccgermantown.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.Log4jConfigListener;


public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext context = getContext();
        servletContext.addListener(new ContextLoaderListener(context));
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        //log4j config
//        servletContext.setInitParameter("log4jConfigLocation", "classpath:config/log4j.xml");
//        servletContext.setInitParameter("log4jRefreshInterval", "10000");
//        servletContext.setInitParameter("log4jExposeWebAppRoot", "false");
//        Log4jConfigListener log4jListener = new Log4jConfigListener();
//        servletContext.addListener(log4jListener);


    }

    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.setConfigLocation("org.cccgermantown.web.contact");
        context.register(AppConfig.class, WebAppConfig.class, PersistenceJPAConfig.class);
        return context;
    }
}
