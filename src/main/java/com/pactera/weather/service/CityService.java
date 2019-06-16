package com.pactera.weather.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pactera.weather.model.City;
import com.pactera.weather.repository.CityRepository;

@Service
public class CityService {
	
	private final CityRepository cityRepository;
	
	public CityService(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}
	
	public List<City> getCityList() {
		return cityRepository.getCityList();
	}
}
