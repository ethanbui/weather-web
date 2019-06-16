package com.pactera.weather.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:api.properties")
@ConfigurationProperties
public class ApiConfig {
	private OpenWeatherConfig openWeather;

	private int connectTimeout;
	private int readTimeout;

	public OpenWeatherConfig getOpenWeather() {
		return openWeather;
	}

	public void setOpenWeather(OpenWeatherConfig openWeather) {
		this.openWeather = openWeather;
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public int getReadTimeout() {
		return readTimeout;
	}

	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}

}
