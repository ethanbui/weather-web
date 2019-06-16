package com.pactera.weather.repository;

import java.util.List;

import com.pactera.weather.model.City;

public interface ICityRepository {
	List<City> getCityList();
}
