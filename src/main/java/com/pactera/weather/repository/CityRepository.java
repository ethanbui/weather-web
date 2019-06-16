package com.pactera.weather.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pactera.weather.model.City;
import com.pactera.weather.util.Constants;

@Repository
public class CityRepository implements ICityRepository {
	private static Logger logger = LoggerFactory.getLogger(CityRepository.class);
	
	@Override
	public List<City> getCityList() {
		TypeReference<List<City>> typeReference = new TypeReference<List<City>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream(Constants.CITY_DATA_FILE);
		ObjectMapper mapper = new ObjectMapper();
		
		List<City> cityList;
		try {
			cityList = mapper.readValue(inputStream, typeReference);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			cityList = new ArrayList<>();
		}
		
		return cityList;
	}

}
