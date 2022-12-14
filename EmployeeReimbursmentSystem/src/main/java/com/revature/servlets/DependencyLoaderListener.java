package com.revature.servlets;

import com.revature.services.DatasourceService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DependencyLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Initializing servlet context...");
        DatasourceService.getConnection();

        System.out.println("Servlet context initialized!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
