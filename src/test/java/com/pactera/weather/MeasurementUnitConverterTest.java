package com.pactera.weather;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pactera.weather.util.MeasurementUnitConverter;

public class MeasurementUnitConverterTest {
	@Test
	public void mpsToKmph_3_1mps_return11_16() {
		final double expected = 11.16;
		 
        final double actual = MeasurementUnitConverter.mpsToKmph(3.1);

        assertEquals(expected, actual, expected);
	}
}
