package com.pactera.weather.service;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.pactera.weather.config.ApiConfig;
import com.pactera.weather.model.OpenWeatherData;
import com.pactera.weather.model.OpenWeatherRequest;
import com.pactera.weather.model.WeatherError;
import com.pactera.weather.util.JsonUtil;

@Service
public class OpenWeatherService implements IWeatherService<OpenWeatherData, OpenWeatherRequest> {
	private final ApiConfig apiConfig;
	private final RestTemplate restTemplate;

	public OpenWeatherService(ApiConfig apiConfig, RestTemplate restTemplate) {
		this.apiConfig = apiConfig;
		this.restTemplate = restTemplate;
	}

	@Override
	public OpenWeatherData getWeatherInfo(OpenWeatherRequest request) {
		StringBuilder requestBuider = new StringBuilder();
		requestBuider.append(apiConfig.getOpenWeather().getBaseUrl());
		requestBuider.append(apiConfig.getOpenWeather().getVersionSpec());
		requestBuider.append(apiConfig.getOpenWeather().getParams());

		String query = String.format("%s,%s", request.getCity(), request.getCountry());
		String apiKey = apiConfig.getOpenWeather().getKey();
		String unit = apiConfig.getOpenWeather().getUnit();

		OpenWeatherData data = null;
		
		try {
			data = restTemplate.getForObject(requestBuider.toString(), OpenWeatherData.class, query, apiKey, unit);
		} catch (HttpClientErrorException e) {
			
			WeatherError weatherError;
			
			try {
				weatherError = JsonUtil.convertJsonToObject(e.getResponseBodyAsString(), WeatherError.class);
			} catch (IOException e1) {
				weatherError = new WeatherError(HttpStatus.INTERNAL_SERVER_ERROR.toString(),
						apiConfig.getOpenWeather().getDefaultErrorMessage());
			}
			
			data = new OpenWeatherData();
			data.setWeatherError(weatherError);
		}

		return data;
	}

}
