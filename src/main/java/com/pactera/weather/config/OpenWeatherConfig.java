package com.pactera.weather.config;

public class OpenWeatherConfig extends AbstractApiConfig {
	private String versionSpec;
	private String key;
	private String params;
	private String unit;
	private String speedSuffix;
	private OpenWeatherResponse response;

	public String getVersionSpec() {
		return versionSpec;
	}

	public void setVersionSpec(String versionSpec) {
		this.versionSpec = versionSpec;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getSpeedSuffix() {
		return speedSuffix;
	}

	public void setSpeedSuffix(String speedSuffix) {
		this.speedSuffix = speedSuffix;
	}

	public OpenWeatherResponse getResponse() {
		return response;
	}

	public void setResponse(OpenWeatherResponse response) {
		this.response = response;
	}

}
