package com.pactera.weather.util;

public class Constants {
	
	private Constants() {
		throw new IllegalStateException(Constants.class.getName());
	}

	public static final String NOT_AVAILABLE = "NA";
	public static final String DATE_FORMAT = "EEEE h:mm a";
	public static final String DOUBLE_FORMAT = "#0.00";
	public static final String CITY_DATA_FILE = "/static/data/city_list.json";
}
