package com.myfirstweb.Configuration;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MyWebAppInitializer implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("onStartUp");
        System.out.println("onStartUp");
        System.out.println("onStartUp");
        System.out.println("onStartUp");
        System.out.println("onStartUp");

    }
}
