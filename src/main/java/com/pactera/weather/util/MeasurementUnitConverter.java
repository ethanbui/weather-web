package com.pactera.weather.util;

public class MeasurementUnitConverter {
	
	private MeasurementUnitConverter() {
		throw new IllegalStateException(MeasurementUnitConverter.class.getName());
	}

	/**
	 * function to convert speed in km/hr to m/sec
	 * 
	 * @param kmph
	 * @return
	 */
	public static double kmphToMps(double kmph) {
		return (0.277778 * kmph);
	}

	/**
	 * function to convert speed in m/sec to km/hr
	 * 
	 * @param mps
	 * @return
	 */
	public static double mpsToKmph(double mps) {
		return (3.6 * mps);
	}
}
