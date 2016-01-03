package org.lanyonm.playground.config;

import javax.servlet.Filter;

import org.lanyonm.playground.service.ExceptionServiceImpl;
import org.lanyonm.playground.service.TodoServiceImpl;
import org.lanyonm.playground.service.UserServiceImpl;
// import org.slf4j.MDC;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

/**
 * Java Config for this application.  Life begins here.
 *
 * @author lanyonm
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// MDC.put("environment", System.getenv("APP_ENV") != null ? System.getenv("APP_ENV") : "dev");
		return new Class<?>[]{DataConfig.class, ExceptionServiceImpl.class, TodoServiceImpl.class, UserServiceImpl.class, ViewResolver.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{WebConfig.class};
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		return new Filter[]{ characterEncodingFilter, new SiteMeshFilter() };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}
