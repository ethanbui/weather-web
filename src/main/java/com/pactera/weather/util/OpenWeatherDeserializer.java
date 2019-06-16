package com.pactera.weather.util;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.pactera.weather.config.ApiConfig;
import com.pactera.weather.config.OpenWeatherResponse;
import com.pactera.weather.model.OpenWeatherData;

public class OpenWeatherDeserializer extends StdDeserializer<OpenWeatherData> {
	private static final long serialVersionUID = 2589574050746889771L;
	
	@Autowired
	private transient ApiConfig apiConfig;
	
	public OpenWeatherDeserializer() {
		this(null);
	}

	public OpenWeatherDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public OpenWeatherData deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException {
		OpenWeatherResponse responseConfig = apiConfig.getOpenWeather().getResponse();
		
		JsonNode node = p.getCodec().readTree(p);
		JsonNode weatherNode = node.get(responseConfig.getWeatherNode());
		JsonNode mainNode = node.get(responseConfig.getMainNode());
		JsonNode windNode = node.get(responseConfig.getWindNode());		
		
		String city = getNodeStringValue(node, responseConfig.getCity());			
		String weather = getNodeStringValue(weatherNode.get(0), responseConfig.getDescription());
		String temperature = getNodeStringValue(mainNode, responseConfig.getTemp());
		String wind = getNodeStringValue(windNode, responseConfig.getSpeed());
		
		return new OpenWeatherData(city, weather, temperature, wind);
	}
	
	private String getNodeStringValue(JsonNode node, String field) {
		return node.get(field).asText(Constants.NOT_AVAILABLE);
	}

}
