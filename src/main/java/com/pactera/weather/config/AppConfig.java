package com.pactera.weather.config;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.pactera.weather.logging.HttpRequestInterceptor;

@Configuration
public class AppConfig {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder, ApiConfig apiConfig) {
		return builder
				.additionalInterceptors(new HttpRequestInterceptor())
				.setConnectTimeout(Duration.ofMillis(apiConfig.getConnectTimeout()))
				.setReadTimeout(Duration.ofMillis(apiConfig.getReadTimeout()))
				.build();
	}

}
