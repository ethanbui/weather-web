package com.pactera.weather.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pactera.weather.util.OpenWeatherDeserializer;

@JsonDeserialize(using = OpenWeatherDeserializer.class)
public class OpenWeatherData extends AbstractWeatherData {
	private String city;
	private String weather;
	private String temperature;
	private String wind;

	public OpenWeatherData() {}
	
	public OpenWeatherData(String city, String weather, String temperature, String wind) {
		this.city = city;
		this.weather = weather;
		this.temperature = temperature;
		this.wind = wind;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getWind() {
		return wind;
	}

	public void setWind(String wind) {
		this.wind = wind;
	}

}
