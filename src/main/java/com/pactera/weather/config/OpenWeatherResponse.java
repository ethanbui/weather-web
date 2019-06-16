package com.pactera.weather.config;

public class OpenWeatherResponse {
	private String weatherNode;
	private String mainNode;
	private String windNode;
	private String description;
	private String temp;
	private String speed;
	private String city;

	public String getWeatherNode() {
		return weatherNode;
	}

	public void setWeatherNode(String weatherNode) {
		this.weatherNode = weatherNode;
	}

	public String getMainNode() {
		return mainNode;
	}

	public void setMainNode(String mainNode) {
		this.mainNode = mainNode;
	}

	public String getWindNode() {
		return windNode;
	}

	public void setWindNode(String windNode) {
		this.windNode = windNode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
