package com.company.spring;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;

import com.company.spring.core.RootConfiguration;

public class ApplicationInitializer implements WebApplicationInitializer {

	AnnotationConfigApplicationContext  appContext;
	
    @Override
    public void onStartup(ServletContext container) {
    	appContext = new AnnotationConfigApplicationContext ();
    	appContext.register(RootConfiguration.class);
    	appContext.refresh();
    }

 }
