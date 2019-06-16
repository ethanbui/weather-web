package com.pactera.weather.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	private JsonUtil() {}
	
	public static <T> T convertJsonToObject(String value, Class<T> type) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(value, type);
	}
	
}
