package com.thanglequoc.aqicalculator.aqi;

import java.io.IOException;

import org.junit.Before;

import com.thanglequoc.aqicalculator.AQICalculator;

public class AQIGeneralMessageTest {
    AQICalculator calculator;

    private String pollutantCode;

    @Before
    public void begin() throws IOException, Exception {
	this.pollutantCode = "";
	calculator = AQICalculator.getAQICalculatorInstance();
    }
    
}
