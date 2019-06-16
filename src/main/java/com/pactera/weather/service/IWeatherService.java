package com.pactera.weather.service;

import com.pactera.weather.model.AbstractWeatherData;
import com.pactera.weather.model.AbstractWeatherRequest;

public interface IWeatherService<T extends AbstractWeatherData, K extends AbstractWeatherRequest> {
	T getWeatherInfo(K request);
}
