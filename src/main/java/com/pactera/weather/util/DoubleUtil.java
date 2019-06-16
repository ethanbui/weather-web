package com.pactera.weather.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class DoubleUtil {
	private DoubleUtil() {}
	/**
	 * Convert double to string with format
	 * 
	 * @param value
	 * @return
	 */
	public static String toString(double value) {
		NumberFormat formatter = new DecimalFormat(Constants.DOUBLE_FORMAT);     
		return formatter.format(value);
	}
}
