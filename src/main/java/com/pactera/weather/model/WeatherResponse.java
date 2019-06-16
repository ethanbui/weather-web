package com.pactera.weather.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.thymeleaf.util.StringUtils;

import com.pactera.weather.util.Constants;
import com.pactera.weather.util.DoubleUtil;
import com.pactera.weather.util.MeasurementUnitConverter;

public class WeatherResponse {

	private WeatherResponse() {
	}

	public static class Builder {
		private String city;
		private String weather;
		private String temperature;
		private String wind;
		private String speedSuffix;
		private boolean isSpeedInKmhr;
		private boolean convertToKmhr;

		public Builder() {}
		
		public Builder(String city, String weather, String temperature, String wind) {
			this.city = city;
			this.weather = weather;
			this.temperature = temperature;
			this.wind = wind;
		}

		public Builder speedSuffix(String speedSuffix) {
			this.speedSuffix = speedSuffix;
			return this;
		}
		
		public Builder isSpeedInKmhr(boolean isSpeedInKmhr) {
			this.isSpeedInKmhr = isSpeedInKmhr;
			return this;
		}

		public Builder convertToKmhr(boolean convertToKmhr) {
			this.convertToKmhr = convertToKmhr;
			return this;
		}

		public WeatherResponse build() {
			WeatherResponse response = new WeatherResponse();
			response.city = this.city;
			response.weather = StringUtils.capitalizeWords(this.weather.toLowerCase());
			response.temperature = this.temperature;
			response.updatedTime = new SimpleDateFormat(Constants.DATE_FORMAT).format(new Date());

			if(!isSpeedInKmhr && convertToKmhr) {
				double windSpeed = Double.parseDouble(this.wind);
				
				StringBuilder speedBuilder = new StringBuilder();
				speedBuilder.append(DoubleUtil.toString(MeasurementUnitConverter.mpsToKmph(windSpeed)));
				speedBuilder.append(this.speedSuffix);
				
				response.wind = speedBuilder.toString();
			} else {
				response.wind = this.wind;
			}
			
			return response;
		}
	}

	private String city;
	private String updatedTime;
	private String weather;
	private String temperature;
	private String wind;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
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
