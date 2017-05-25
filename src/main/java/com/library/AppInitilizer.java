package com.library;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitilizer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();

		ctx.register(AppConfig.class);
		ctx.setServletContext(container);

		ServletRegistration.Dynamic dispactherServlet = container.addServlet("dispacther", new DispatcherServlet(ctx));

		dispactherServlet.setLoadOnStartup(1);
		dispactherServlet.addMapping("/");

	}

}
