package com.thanglequoc.aqicalculator.aqi;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.thanglequoc.aqicalculator.AQICalculator;
import com.thanglequoc.aqicalculator.AQIResult;
import com.thanglequoc.aqicalculator.PollutantCode;

public class AQIMessageTest {
    AQICalculator calculator;

    private String pollutantCode;
    private String category;
    private String generalMessage;
    private String specificGuidanceMessage;
    private String healthEffectsStatements;

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
	
	
	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.GOOD.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.GOOD.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForPM10.GOOD.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForPM10.GOOD.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }

    @Test
    public void should_ReturnGoodAQILevel_When_AQIPM25Is40() {
	pollutantCode = PollutantCode.PM25.getLiteral();
	double avgConcentration = 9.6;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);
	
	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.GOOD.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.GOOD.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForPM25.GOOD.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForPM25.GOOD.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }

    @Test
    public void should_ReturnGoodAQILevel_When_AQIO3Is10() {
	pollutantCode = PollutantCode.O3.getLiteral();

	double avgConcentration = 10;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.GOOD.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.GOOD.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForO3.GOOD.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForO3.GOOD.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }

    @Test
    public void should_ReturnGoodAQILevel_When_AQICOIs17() {
	pollutantCode = PollutantCode.CO.getLiteral();

	double avgConcentration = 1400;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.GOOD.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.GOOD.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForCO.GOOD.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForCO.GOOD.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }

    @Test
    public void should_ReturnGoodAQILevel_When_AQISO2Is49() {
	pollutantCode = PollutantCode.SO2.getLiteral();

	double avgConcentration = 34;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.GOOD.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.GOOD.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForSO2.GOOD.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForSO2.GOOD.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }

    @Test
    public void should_ReturnGoodAQILevel_When_AQINO2Is37() {
	pollutantCode = PollutantCode.NO2.getLiteral();

	double avgConcentration = 39;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.GOOD.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.GOOD.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForNO2.GOOD.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForNO2.GOOD.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
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

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.MODERATE.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.MODERATE.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForPM10.MODERATE.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForPM10.MODERATE.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }

    @Test
    public void should_ReturnModerateAQILevel_When_AQIPM25Is85() {
	pollutantCode = PollutantCode.PM25.getLiteral();

	double avgConcentration = 28.2;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.MODERATE.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.MODERATE.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForPM25.MODERATE.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForPM25.MODERATE.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }

    @Test
    public void should_ReturnModerateAQILevel_When_AQIO3Is93() {
	pollutantCode = PollutantCode.O3.getLiteral();

	double avgConcentration = 67;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.MODERATE.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.MODERATE.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForO3.MODERATE.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForO3.MODERATE.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }

    @Test
    public void should_ReturnModerateAQILevel_When_AQICOIs61() {
	pollutantCode = PollutantCode.CO.getLiteral();

	double avgConcentration = 5500;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.MODERATE.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.MODERATE.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForCO.MODERATE.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForCO.MODERATE.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }

    @Test
    public void should_ReturnModerateAQILevel_When_AQISO2Is51() {
	pollutantCode = PollutantCode.SO2.getLiteral();

	double avgConcentration = 36;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.MODERATE.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.MODERATE.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForSO2.MODERATE.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForSO2.MODERATE.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }

    @Test
    public void should_ReturnModerateAQILevel_When_AQINO2Is97() {
	pollutantCode = PollutantCode.NO2.getLiteral();

	double avgConcentration = 99;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.MODERATE.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.MODERATE.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForNO2.MODERATE.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForNO2.MODERATE.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
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

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.UNHEALTHY_FOR_SENSITIVE_GROUPS.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.UNHEALTHY_FOR_SENSITIVE_GROUPS.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForPM10.UNHEALTHY_FOR_SENSITIVE_GROUPS.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForPM10.UNHEALTHY_FOR_SENSITIVE_GROUPS.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }
    
    @Test
    public void should_ReturnUnhealthyForSensitiveGroupsAQILevel_When_AQIPM25Is112() {
	pollutantCode = PollutantCode.PM25.getLiteral();

	double avgConcentration = 39.9;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.UNHEALTHY_FOR_SENSITIVE_GROUPS.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.UNHEALTHY_FOR_SENSITIVE_GROUPS.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForPM25.UNHEALTHY_FOR_SENSITIVE_GROUPS.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForPM25.UNHEALTHY_FOR_SENSITIVE_GROUPS.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }
    
    @Test
    public void should_ReturnUnhealthyForSensitiveGroupsAQILevel_When_AQIO3Is126() {
	pollutantCode = PollutantCode.O3.getLiteral();

	double avgConcentration = 78;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.UNHEALTHY_FOR_SENSITIVE_GROUPS.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.UNHEALTHY_FOR_SENSITIVE_GROUPS.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForO3.UNHEALTHY_FOR_SENSITIVE_GROUPS.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForO3.UNHEALTHY_FOR_SENSITIVE_GROUPS.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }
    
    @Test
    public void should_ReturnUnhealthyForSensitiveGroupsAQILevel_When_AQICOIs138() {
	pollutantCode = PollutantCode.CO.getLiteral();

	double avgConcentration = 11600;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.UNHEALTHY_FOR_SENSITIVE_GROUPS.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.UNHEALTHY_FOR_SENSITIVE_GROUPS.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForCO.UNHEALTHY_FOR_SENSITIVE_GROUPS.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForCO.UNHEALTHY_FOR_SENSITIVE_GROUPS.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }
    
    
    @Test
    public void should_ReturnUnhealthyForSensitiveGroupsAQILevel_When_AQISO2Is137() {
	pollutantCode = PollutantCode.SO2.getLiteral();

	double avgConcentration = 156;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.UNHEALTHY_FOR_SENSITIVE_GROUPS.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.UNHEALTHY_FOR_SENSITIVE_GROUPS.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForSO2.UNHEALTHY_FOR_SENSITIVE_GROUPS.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForSO2.UNHEALTHY_FOR_SENSITIVE_GROUPS.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }
    
    @Test
    public void should_ReturnUnhealthyForSensitiveGroupsAQILevel_When_AQINO2Is149() {
	pollutantCode = PollutantCode.NO2.getLiteral();

	double avgConcentration = 354;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.UNHEALTHY_FOR_SENSITIVE_GROUPS.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.UNHEALTHY_FOR_SENSITIVE_GROUPS.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForNO2.UNHEALTHY_FOR_SENSITIVE_GROUPS.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForNO2.UNHEALTHY_FOR_SENSITIVE_GROUPS.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
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

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.UNHEALTHY.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.UNHEALTHY.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForPM10.UNHEALTHY.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForPM10.UNHEALTHY.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }
    
    @Test
    public void should_ReturnUnhealthyAQILevel_When_AQIPM25Is168() {
	pollutantCode = PollutantCode.PM25.getLiteral();

	double avgConcentration = 88.4;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.UNHEALTHY.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.UNHEALTHY.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForPM25.UNHEALTHY.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForPM25.UNHEALTHY.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }
    
    @Test
    public void should_ReturnUnhealthyAQILevel_When_AQIO3Is161() {
	pollutantCode = PollutantCode.O3.getLiteral();

	double avgConcentration = 89;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.UNHEALTHY.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.UNHEALTHY.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForO3.UNHEALTHY.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForO3.UNHEALTHY.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }
    
    @Test
    public void should_ReturnUnhealthyAQILevel_When_AQICOIs178() {
	pollutantCode = PollutantCode.CO.getLiteral();

	double avgConcentration = 14000;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.UNHEALTHY.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.UNHEALTHY.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForCO.UNHEALTHY.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForCO.UNHEALTHY.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }
    
    @Test
    public void should_ReturnUnhealthyAQILevel_When_AQISO2Is185() {
	pollutantCode = PollutantCode.SO2.getLiteral();

	double avgConcentration = 267;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.UNHEALTHY.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.UNHEALTHY.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForSO2.UNHEALTHY.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForSO2.UNHEALTHY.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }
    
    @Test
    public void should_ReturnUnhealthyAQILevel_When_AQINO2Is198() {
	pollutantCode = PollutantCode.NO2.getLiteral();

	double avgConcentration = 637;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.UNHEALTHY.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.UNHEALTHY.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForNO2.UNHEALTHY.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForNO2.UNHEALTHY.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
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

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.VERY_UNHEALTHY.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.VERY_UNHEALTHY.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForPM10.VERY_UNHEALTHY.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForPM10.VERY_UNHEALTHY.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }
    
    @Test
    public void should_ReturnVeryUnhealthyAQILevel_When_AQIPM25Is248() {
	pollutantCode = PollutantCode.PM25.getLiteral();

	double avgConcentration = 197.9;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.VERY_UNHEALTHY.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.VERY_UNHEALTHY.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForPM25.VERY_UNHEALTHY.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForPM25.VERY_UNHEALTHY.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }
    
    @Test
    public void should_ReturnVeryUnhealthyAQILevel_When_AQIO3Is263() {
	pollutantCode = PollutantCode.O3.getLiteral();

	double avgConcentration = 164;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.VERY_UNHEALTHY.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.VERY_UNHEALTHY.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForO3.VERY_UNHEALTHY.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForO3.VERY_UNHEALTHY.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }
    
    @Test
    public void should_ReturnVeryUnhealthyAQILevel_When_AQICOIs279() {
	pollutantCode = PollutantCode.CO.getLiteral();

	double avgConcentration = 27200;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.VERY_UNHEALTHY.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.VERY_UNHEALTHY.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForCO.VERY_UNHEALTHY.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForCO.VERY_UNHEALTHY.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }
    
    @Test
    public void should_ReturnVeryUnhealthyAQILevel_When_AQINO2Is299() {
	pollutantCode = PollutantCode.NO2.getLiteral();

	double avgConcentration = 1238;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.VERY_UNHEALTHY.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.VERY_UNHEALTHY.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForNO2.VERY_UNHEALTHY.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForNO2.VERY_UNHEALTHY.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
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

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.HAZARDOUS.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.HAZARDOUS.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForPM10.HAZARDOUS.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForPM10.HAZARDOUS.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }
    
    @Test
    public void should_ReturnHazardousAQILevel_When_AQIPM25Is399() {
	pollutantCode = PollutantCode.PM25.getLiteral();

	double avgConcentration = 349.3;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.HAZARDOUS.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.HAZARDOUS.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForPM25.HAZARDOUS.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForPM25.HAZARDOUS.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }
    
    @Test
    public void should_ReturnHazardousAQILevel_When_AQICOIs431() {
	pollutantCode = PollutantCode.CO.getLiteral();

	double avgConcentration = 43500;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.HAZARDOUS.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.HAZARDOUS.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForCO.HAZARDOUS.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForCO.HAZARDOUS.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }
    
    @Test
    public void should_ReturnHazardousAQILevel_When_AQINO2Is500() {
	pollutantCode = PollutantCode.NO2.getLiteral();

	double avgConcentration = 2044;
	AQIResult result = calculator.getAQI(pollutantCode, avgConcentration);

	category = result.getCategory();
	generalMessage = result.getGeneralMessage();
	specificGuidanceMessage = result.getGuidanceStatement();
	healthEffectsStatements = result.getHealthEffectsStatement();
	
	String expectedCategory = AQILevel.HAZARDOUS.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.HAZARDOUS.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForNO2.HAZARDOUS.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForNO2.HAZARDOUS.getHealthEffectsStatements();
	
	assertEquals(expectedCategory, category);
	assertEquals(expectedGeneralMessage, generalMessage);
	assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
	assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
    }
    
    /**
     * ----- Begin test for Invalid Concentration Range
     * ---------------------------------------------------------------------
     */
    
    @Test
    public void should_ReturnInvalidMessage_When_ConcentrationRangeExceeded(){
	String pollutantCode = PollutantCode.PM10.getLiteral();
	
	String expectedCategory = AQILevel.HAZARDOUS.getLiteral();
	String expectedGeneralMessage = AQILevelGeneralMessage.HAZARDOUS.getGeneralGuidanceMessage();
	String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForNO2.HAZARDOUS.getGuidance();
	String expectedHealthEffectsStatements = AQILevelSpecificMessageForNO2.HAZARDOUS.getHealthEffectsStatements();
	
    }

    

}
