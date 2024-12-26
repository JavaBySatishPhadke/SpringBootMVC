package com.nt;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class BootMvcProj17I18nApplication {
	
	
	@Bean(name="localeResolver")  //fixed bean id 
	public   SessionLocaleResolver createResolver() {
		  SessionLocaleResolver resolver=new SessionLocaleResolver();
		  resolver.setDefaultLocale(new Locale("en","US"));
		  return resolver;
	}
	
	@Bean(name="lci")  //any bean id can be given
	public    LocaleChangeInterceptor  createInterceptor() {
		LocaleChangeInterceptor interceptor=new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj17I18nApplication.class, args);
	}

}
