package com.pactera.weather.config;

public abstract class AbstractApiConfig {
	private String baseUrl;
	private String defaultErrorMessage;
	private String cityNotSupport;

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getDefaultErrorMessage() {
		return defaultErrorMessage;
	}

	public void setDefaultErrorMessage(String defaultErrorMessage) {
		this.defaultErrorMessage = defaultErrorMessage;
	}

	public String getCityNotSupport() {
		return cityNotSupport;
	}

	public void setCityNotSupport(String cityNotSupport) {
		this.cityNotSupport = cityNotSupport;
	}

}
