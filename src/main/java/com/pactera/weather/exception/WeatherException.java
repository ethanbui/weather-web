package com.pactera.weather.exception;

public class WeatherException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public WeatherException(String msg) {
        super(msg);
    }
}
