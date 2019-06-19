package com.pactera.weather.controller;

import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pactera.weather.config.ApiConfig;
import com.pactera.weather.exception.WeatherException;
import com.pactera.weather.model.City;
import com.pactera.weather.model.OpenWeatherData;
import com.pactera.weather.model.OpenWeatherRequest;
import com.pactera.weather.model.WeatherResponse;
import com.pactera.weather.service.CityService;
import com.pactera.weather.service.OpenWeatherService;

@Controller
public class WeatherController {

	private final ApiConfig apiConfig;
	private final OpenWeatherService weatherService;
	private final CityService cityService;

	public WeatherController(ApiConfig apiConfig, OpenWeatherService weatherService, CityService cityService) {
		this.apiConfig = apiConfig;
		this.weatherService = weatherService;
		this.cityService = cityService;
	}

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

	@GetMapping(path = "/retrieveCityList.json", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> retrieveCityList() {
		List<City> cityList = cityService.getCityList();
		
		return new ResponseEntity<>(cityList, HttpStatus.OK);
	}
	
	@PostMapping(path = "/retrieveCityWeather.json", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> retrieveCityWeather(@RequestParam String id, TimeZone timeZone) {
		List<City> cityList = cityService.getCityList();
		Optional<City> optCity = cityList.stream().filter(city -> id.equals(city.getId())).findFirst();
		
		if(!optCity.isPresent()) {
			// response unsupported city message
			throw new WeatherException(apiConfig.getOpenWeather().getCityNotSupport());
		}
				
		OpenWeatherRequest request = new OpenWeatherRequest();
		request.setCity(optCity.get().getName());
		request.setCountry(optCity.get().getCountry());
		
		OpenWeatherData weatherData = weatherService.getWeatherInfo(request);
		if (weatherData.getWeatherError() != null) {
			// response error message from open weather API
			throw new WeatherException(weatherData.getWeatherError().getMessage());
		}
		
		WeatherResponse response = new WeatherResponse
				.Builder(weatherData.getCity(), weatherData.getWeather(), weatherData.getTemperature(), weatherData.getWind())
						.speedSuffix(apiConfig.getOpenWeather().getSpeedSuffix())
						.isSpeedInKmhr(false)
						.convertToKmhr(true)
						.timeZone(timeZone)
						.build();
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
