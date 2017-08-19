package com.thanglequoc.aqicalculator.categorylevel;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.thanglequoc.aqicalculator.AQICalculator;
import com.thanglequoc.aqicalculator.AQIResult;
import com.thanglequoc.aqicalculator.PollutantCode;

public class AQICategoryTest {
    AQICalculator calculator;

    private String pollutantCode;

    @Before
    public void begin() throws IOException, Exception {
	this.pollutantCode = "";
	calculator = AQICalculator.getAQICalculatorInstance();
    }

    /**
     * ----- Begin test for Good Category level
     * ---------------------------------------------------------------------
     */

    @Test
    public void should_ReturnGoodAQILevel_When_AQIPM10Is30() {
	pollutantCode = PollutantCode.PM10.getLiteral();

	double avgConcentration = 32;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.GOOD.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }

    @Test
    public void should_ReturnGoodAQILevel_When_AQIPM25Is40() {
	pollutantCode = PollutantCode.PM25.getLiteral();

	double avgConcentration = 9.6;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.GOOD.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }

    @Test
    public void should_ReturnGoodAQILevel_When_AQIO3Is10() {
	pollutantCode = PollutantCode.O3.getLiteral();

	double avgConcentration = 10;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.GOOD.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }

    @Test
    public void should_ReturnGoodAQILevel_When_AQICOIs17() {
	pollutantCode = PollutantCode.CO.getLiteral();

	double avgConcentration = 1400;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.GOOD.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }

    @Test
    public void should_ReturnGoodAQILevel_When_AQISO2Is49() {
	pollutantCode = PollutantCode.SO2.getLiteral();

	double avgConcentration = 34;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.GOOD.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }

    @Test
    public void should_ReturnGoodAQILevel_When_AQINO2Is37() {
	pollutantCode = PollutantCode.NO2.getLiteral();

	double avgConcentration = 39;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.GOOD.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }

    /**
     * ----- Begin test for Moderate level
     * ---------------------------------------------------------------------
     */

    @Test
    public void should_ReturnModerateAQILevel_When_AQIPM10Is73() {
	pollutantCode = PollutantCode.PM10.getLiteral();

	double avgConcentration = 99;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.MODERATE.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }

    @Test
    public void should_ReturnModerateAQILevel_When_AQIPM25Is85() {
	pollutantCode = PollutantCode.PM25.getLiteral();

	double avgConcentration = 28.2;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.MODERATE.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }

    @Test
    public void should_ReturnModerateAQILevel_When_AQIO3Is93() {
	pollutantCode = PollutantCode.O3.getLiteral();

	double avgConcentration = 67;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.MODERATE.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }

    @Test
    public void should_ReturnModerateAQILevel_When_AQICOIs61() {
	pollutantCode = PollutantCode.CO.getLiteral();

	double avgConcentration = 5500;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.MODERATE.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }

    @Test
    public void should_ReturnModerateAQILevel_When_AQISO2Is51() {
	pollutantCode = PollutantCode.SO2.getLiteral();

	double avgConcentration = 36;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.MODERATE.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }

    @Test
    public void should_ReturnModerateAQILevel_When_AQINO2Is97() {
	pollutantCode = PollutantCode.NO2.getLiteral();

	double avgConcentration = 99;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.MODERATE.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }

    /**
     * ----- Begin test for Unhealthy for Sensitive Groups level
     * ---------------------------------------------------------------------
     */

    @Test
    public void should_ReturnUnhealthyForSensitiveGroupsAQILevel_When_AQIPM10Is104() {
	pollutantCode = PollutantCode.PM10.getLiteral();

	double avgConcentration = 161;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.UNHEALTHY_FOR_SENSITIVE_GROUPS.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }
    
    @Test
    public void should_ReturnUnhealthyForSensitiveGroupsAQILevel_When_AQIPM25Is112() {
	pollutantCode = PollutantCode.PM25.getLiteral();

	double avgConcentration = 39.9;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.UNHEALTHY_FOR_SENSITIVE_GROUPS.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }
    
    @Test
    public void should_ReturnUnhealthyForSensitiveGroupsAQILevel_When_AQIO3Is126() {
	pollutantCode = PollutantCode.O3.getLiteral();

	double avgConcentration = 78;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.UNHEALTHY_FOR_SENSITIVE_GROUPS.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }
    
    @Test
    public void should_ReturnUnhealthyForSensitiveGroupsAQILevel_When_AQICOIs138() {
	pollutantCode = PollutantCode.CO.getLiteral();

	double avgConcentration = 11600;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.UNHEALTHY_FOR_SENSITIVE_GROUPS.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }
    
    
    @Test
    public void should_ReturnUnhealthyForSensitiveGroupsAQILevel_When_AQISO2Is137() {
	pollutantCode = PollutantCode.SO2.getLiteral();

	double avgConcentration = 156;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.UNHEALTHY_FOR_SENSITIVE_GROUPS.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }
    
    @Test
    public void should_ReturnUnhealthyForSensitiveGroupsAQILevel_When_AQINO2Is149() {
	pollutantCode = PollutantCode.NO2.getLiteral();

	double avgConcentration = 354;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.UNHEALTHY_FOR_SENSITIVE_GROUPS.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }
    
    /**
     * ----- Begin test for Unhealthy Category level
     * ---------------------------------------------------------------------
     */
    
    @Test
    public void should_ReturnUnhealthyAQILevel_When_AQIPM10Is151() {
	pollutantCode = PollutantCode.PM10.getLiteral();

	double avgConcentration = 255;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.UNHEALTHY.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }
    
    @Test
    public void should_ReturnUnhealthyAQILevel_When_AQIPM25Is168() {
	pollutantCode = PollutantCode.PM25.getLiteral();

	double avgConcentration = 88.4;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.UNHEALTHY.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }
    
    @Test
    public void should_ReturnUnhealthyAQILevel_When_AQIO3Is161() {
	pollutantCode = PollutantCode.O3.getLiteral();

	double avgConcentration = 89;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.UNHEALTHY.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }
    
    @Test
    public void should_ReturnUnhealthyAQILevel_When_AQICOIs178() {
	pollutantCode = PollutantCode.CO.getLiteral();

	double avgConcentration = 14000;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.UNHEALTHY.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }
    
    @Test
    public void should_ReturnUnhealthyAQILevel_When_AQISO2Is185() {
	pollutantCode = PollutantCode.SO2.getLiteral();

	double avgConcentration = 267;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.UNHEALTHY.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }
    
    @Test
    public void should_ReturnUnhealthyAQILevel_When_AQINO2Is198() {
	pollutantCode = PollutantCode.NO2.getLiteral();

	double avgConcentration = 637;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.UNHEALTHY.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }
    
    /**
     * ----- Begin test for Very Unhealthy Category level
     * ---------------------------------------------------------------------
     */
    
    @Test
    public void should_ReturnVeryUnhealthyAQILevel_When_AQIPM10Is233() {
	pollutantCode = PollutantCode.PM10.getLiteral();

	double avgConcentration = 377;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.VERY_UNHEALTHY.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }
    
    @Test
    public void should_ReturnVeryUnhealthyAQILevel_When_AQIPM25Is248() {
	pollutantCode = PollutantCode.PM25.getLiteral();

	double avgConcentration = 197.9;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.VERY_UNHEALTHY.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }
    
    @Test
    public void should_ReturnVeryUnhealthyAQILevel_When_AQIO3Is263() {
	pollutantCode = PollutantCode.O3.getLiteral();

	double avgConcentration = 164;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.VERY_UNHEALTHY.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }
    
    @Test
    public void should_ReturnVeryUnhealthyAQILevel_When_AQICOIs279() {
	pollutantCode = PollutantCode.CO.getLiteral();

	double avgConcentration = 27200;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.VERY_UNHEALTHY.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }
    
    @Test
    public void should_ReturnVeryUnhealthyAQILevel_When_AQINO2Is299() {
	pollutantCode = PollutantCode.NO2.getLiteral();

	double avgConcentration = 1238;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.VERY_UNHEALTHY.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }
    
    /**
     * ----- Begin test for Hazardous Category level
     * ---------------------------------------------------------------------
     */
    
    @Test
    public void should_ReturnHazardousAQILevel_When_AQIPM10Is358() {
	pollutantCode = PollutantCode.PM10.getLiteral();

	double avgConcentration = 470;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.HAZARDOUS.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }
    
    @Test
    public void should_ReturnHazardousAQILevel_When_AQIPM25Is399() {
	pollutantCode = PollutantCode.PM25.getLiteral();

	double avgConcentration = 349.3;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.HAZARDOUS.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }
    
    @Test
    public void should_ReturnHazardousAQILevel_When_AQICOIs431() {
	pollutantCode = PollutantCode.CO.getLiteral();

	double avgConcentration = 43500;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.HAZARDOUS.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }
    
    @Test
    public void should_ReturnHazardousAQILevel_When_AQINO2Is500() {
	pollutantCode = PollutantCode.NO2.getLiteral();

	double avgConcentration = 2044;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	String expectedCategory = AQILevel.HAZARDOUS.getLiteral();
	String actualCategory = result.getCategory();
	assertEquals(expectedCategory, actualCategory);
    }

    

}
