package com.pactera.weather;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.pactera.weather.model.WeatherError;
import com.pactera.weather.util.JsonUtil;

public class JsonUtilTest {
	@Test
	public void convertCityNotFound() {
		final String json = "{\"cod\":\"404\",\"message\":\"city not found\"}";
		 
        WeatherError actual;
		try {
			actual = JsonUtil.convertJsonToObject(json, WeatherError.class);
			assertEquals("city not found", actual.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}
}
