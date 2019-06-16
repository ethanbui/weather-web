package com.pactera.weather.model;

public abstract class AbstractWeatherData {
	private WeatherError weatherError;

	public WeatherError getWeatherError() {
		return weatherError;
	}

	public void setWeatherError(WeatherError weatherError) {
		this.weatherError = weatherError;
	}

}
