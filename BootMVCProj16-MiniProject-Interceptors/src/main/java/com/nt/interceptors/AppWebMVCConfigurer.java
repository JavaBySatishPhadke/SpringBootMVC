package com.nt.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class AppWebMVCConfigurer implements WebMvcConfigurer {
	@Autowired
	private  TimeOutCheckInterceptor    interceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("AppWebMVCConfigurer.addInterceptors()");
	  //register the Interceptor
		    registry.addInterceptor(interceptor);
	}
	
	

}
