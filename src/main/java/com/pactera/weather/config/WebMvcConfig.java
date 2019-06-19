package com.pactera.weather.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/jquery/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/jquery/3.4.1/");

		registry.addResourceHandler("/popper/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/popper.js/1.14.3/umd/");

		registry.addResourceHandler("/bootstrap/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/4.3.1/");
		
		registry.addResourceHandler("/momentjs/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/momentjs/2.24.0/");
		
		registry.addResourceHandler("/scripts/**") //
				.addResourceLocations("classpath:/static/js/");

	}
}
