package com.thanglequoc.aqicalculator.aqi;

import com.thanglequoc.aqicalculator.AQICalculator;
import com.thanglequoc.aqicalculator.AQICustomSettings;
import com.thanglequoc.aqicalculator.AQIResult;
import com.thanglequoc.aqicalculator.Pollutant;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AQIMessageTest {
    AQICalculator calculator;
    
    private Pollutant pollutant;
    private String category;
    private String generalMessage;
    private String specificGuidanceMessage;
    private String healthEffectsStatements;
    
    static String UNCATEGORIZED = "Uncategorized";
    static String INVALID_GENERAL_MESSAGE = "Invalid pollutant concentration range for calculation";
    static String NOT_APPLICABLE = "N/A";
    
    @Before
    public void begin() throws IOException, Exception {
        calculator = AQICalculator.getAQICalculatorInstance();
    }
    
    /**
     * ----- Begin test for Good Category level
     * ---------------------------------------------------------------------
     */
    
    @Test
    public void should_ReturnGoodAQILevel_When_AQIPM10Is30() {
        pollutant = Pollutant.PM10;
        double avgConcentration = 32;

        AQIResult result = calculator.getAQI(pollutant, avgConcentration);

        assertEquals(AQILevel.GOOD.getLiteral(), result.getCategory());
        assertEquals(AQILevel.GOOD.getColor(), result.getColor());
        assertEquals(AQILevelGenericMessages.GOOD.getMeaning(), result.getMeaning());
        assertEquals(AQILevelSpecificMessageForPM10.GOOD.getGuidance(), result.getGuidanceStatement());
        assertEquals(AQILevelSpecificMessageForPM10.GOOD.getHealthEffectsStatements(), result.getHealthEffectsStatement());
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnGoodAQILevel_When_AQIPM25Is40() {
        pollutant = Pollutant.PM25;
        double avgConcentration = 9.6;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.GOOD.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.GOOD.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForPM25.GOOD.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForPM25.GOOD.getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnGoodAQILevel_When_AQIO3Is10() {
        pollutant = Pollutant.O3;
        
        double avgConcentration = 10;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.GOOD.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.GOOD.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForO3.GOOD.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForO3.GOOD.getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnGoodAQILevel_When_AQICOIs17() {
        pollutant = Pollutant.CO;
        
        double avgConcentration = 1400;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.GOOD.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.GOOD.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForCO.GOOD.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForCO.GOOD.getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnGoodAQILevel_When_AQISO2Is49() {
        pollutant = Pollutant.SO2;
        
        double avgConcentration = 34;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.GOOD.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.GOOD.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForSO2.GOOD.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForSO2.GOOD.getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnGoodAQILevel_When_AQINO2Is37() {
        pollutant = Pollutant.NO2;
        
        double avgConcentration = 39;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.GOOD.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.GOOD.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForNO2.GOOD.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForNO2.GOOD.getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    /**
     * ----- Begin test for Moderate level
     * ---------------------------------------------------------------------
     */
    
    @Test
    public void should_ReturnModerateAQILevel_When_AQIPM10Is73() {
        pollutant = Pollutant.PM10;
        
        double avgConcentration = 99;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.MODERATE.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.MODERATE.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForPM10.MODERATE.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForPM10.MODERATE.getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnModerateAQILevel_When_AQIPM25Is85() {
        pollutant = Pollutant.PM25;
        
        double avgConcentration = 28.2;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.MODERATE.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.MODERATE.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForPM25.MODERATE.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForPM25.MODERATE.getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnModerateAQILevel_When_AQIO3Is93() {
        pollutant = Pollutant.O3;
        
        double avgConcentration = 67;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.MODERATE.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.MODERATE.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForO3.MODERATE.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForO3.MODERATE.getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnModerateAQILevel_When_AQICOIs61() {
        pollutant = Pollutant.CO;
        
        double avgConcentration = 5500;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.MODERATE.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.MODERATE.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForCO.MODERATE.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForCO.MODERATE.getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnModerateAQILevel_When_AQISO2Is51() {
        pollutant = Pollutant.SO2;
        
        double avgConcentration = 36;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.MODERATE.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.MODERATE.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForSO2.MODERATE.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForSO2.MODERATE.getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnModerateAQILevel_When_AQINO2Is97() {
        pollutant = Pollutant.NO2;
        
        double avgConcentration = 99;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.MODERATE.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.MODERATE.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForNO2.MODERATE.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForNO2.MODERATE.getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    /**
     * ----- Begin test for Unhealthy for Sensitive Groups level
     * ---------------------------------------------------------------------
     */
    
    @Test
    public void should_ReturnUnhealthyForSensitiveGroupsAQILevel_When_AQIPM10Is104() {
        pollutant = Pollutant.PM10;
        
        double avgConcentration = 161;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.UNHEALTHY_FOR_SENSITIVE_GROUPS.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.UNHEALTHY_FOR_SENSITIVE_GROUPS
                .getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForPM10.UNHEALTHY_FOR_SENSITIVE_GROUPS
                .getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForPM10.UNHEALTHY_FOR_SENSITIVE_GROUPS
                .getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnUnhealthyForSensitiveGroupsAQILevel_When_AQIPM25Is112() {
        pollutant = Pollutant.PM25;
        
        double avgConcentration = 39.9;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.UNHEALTHY_FOR_SENSITIVE_GROUPS.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.UNHEALTHY_FOR_SENSITIVE_GROUPS
                .getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForPM25.UNHEALTHY_FOR_SENSITIVE_GROUPS
                .getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForPM25.UNHEALTHY_FOR_SENSITIVE_GROUPS
                .getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnUnhealthyForSensitiveGroupsAQILevel_When_AQIO3Is126() {
        pollutant = Pollutant.O3;
        
        double avgConcentration = 78;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.UNHEALTHY_FOR_SENSITIVE_GROUPS.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.UNHEALTHY_FOR_SENSITIVE_GROUPS
                .getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForO3.UNHEALTHY_FOR_SENSITIVE_GROUPS
                .getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForO3.UNHEALTHY_FOR_SENSITIVE_GROUPS
                .getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnUnhealthyForSensitiveGroupsAQILevel_When_AQICOIs138() {
        pollutant = Pollutant.CO;
        
        double avgConcentration = 11600;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.UNHEALTHY_FOR_SENSITIVE_GROUPS.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.UNHEALTHY_FOR_SENSITIVE_GROUPS
                .getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForCO.UNHEALTHY_FOR_SENSITIVE_GROUPS
                .getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForCO.UNHEALTHY_FOR_SENSITIVE_GROUPS
                .getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnUnhealthyForSensitiveGroupsAQILevel_When_AQISO2Is137() {
        pollutant = Pollutant.SO2;
        
        double avgConcentration = 156;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.UNHEALTHY_FOR_SENSITIVE_GROUPS.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.UNHEALTHY_FOR_SENSITIVE_GROUPS
                .getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForSO2.UNHEALTHY_FOR_SENSITIVE_GROUPS
                .getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForSO2.UNHEALTHY_FOR_SENSITIVE_GROUPS
                .getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnUnhealthyForSensitiveGroupsAQILevel_When_AQINO2Is149() {
        pollutant = Pollutant.NO2;
        
        double avgConcentration = 354;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.UNHEALTHY_FOR_SENSITIVE_GROUPS.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.UNHEALTHY_FOR_SENSITIVE_GROUPS
                .getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForNO2.UNHEALTHY_FOR_SENSITIVE_GROUPS
                .getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForNO2.UNHEALTHY_FOR_SENSITIVE_GROUPS
                .getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    /**
     * ----- Begin test for Unhealthy Category level
     * ---------------------------------------------------------------------
     */
    
    @Test
    public void should_ReturnUnhealthyAQILevel_When_AQIPM10Is151() {
        pollutant = Pollutant.PM10;
        
        double avgConcentration = 255;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.UNHEALTHY.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.UNHEALTHY.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForPM10.UNHEALTHY.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForPM10.UNHEALTHY.getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnUnhealthyAQILevel_When_AQIPM25Is168() {
        pollutant = Pollutant.PM25;
        
        double avgConcentration = 88.4;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.UNHEALTHY.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.UNHEALTHY.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForPM25.UNHEALTHY.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForPM25.UNHEALTHY.getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnUnhealthyAQILevel_When_AQIO3Is161() {
        pollutant = Pollutant.O3;
        
        double avgConcentration = 89;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.UNHEALTHY.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.UNHEALTHY.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForO3.UNHEALTHY.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForO3.UNHEALTHY.getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnUnhealthyAQILevel_When_AQICOIs178() {
        pollutant = Pollutant.CO;
        
        double avgConcentration = 14000;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.UNHEALTHY.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.UNHEALTHY.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForCO.UNHEALTHY.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForCO.UNHEALTHY.getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnUnhealthyAQILevel_When_AQISO2Is185() {
        pollutant = Pollutant.SO2;
        
        double avgConcentration = 267;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.UNHEALTHY.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.UNHEALTHY.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForSO2.UNHEALTHY.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForSO2.UNHEALTHY.getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnUnhealthyAQILevel_When_AQINO2Is198() {
        pollutant = Pollutant.NO2;
        
        double avgConcentration = 637;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.UNHEALTHY.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.UNHEALTHY.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForNO2.UNHEALTHY.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForNO2.UNHEALTHY.getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    /**
     * ----- Begin test for Very Unhealthy Category level
     * ---------------------------------------------------------------------
     */
    
    @Test
    public void should_ReturnVeryUnhealthyAQILevel_When_AQIPM10Is233() {
        pollutant = Pollutant.PM10;
        
        double avgConcentration = 377;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.VERY_UNHEALTHY.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.VERY_UNHEALTHY.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForPM10.VERY_UNHEALTHY.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForPM10.VERY_UNHEALTHY
                .getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnVeryUnhealthyAQILevel_When_AQIPM25Is248() {
        pollutant = Pollutant.PM25;
        
        double avgConcentration = 197.9;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.VERY_UNHEALTHY.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.VERY_UNHEALTHY.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForPM25.VERY_UNHEALTHY.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForPM25.VERY_UNHEALTHY
                .getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnVeryUnhealthyAQILevel_When_AQIO3Is263() {
        pollutant = Pollutant.O3;
        
        double avgConcentration = 164;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.VERY_UNHEALTHY.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.VERY_UNHEALTHY.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForO3.VERY_UNHEALTHY.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForO3.VERY_UNHEALTHY
                .getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnVeryUnhealthyAQILevel_When_AQICOIs279() {
        pollutant = Pollutant.CO;
        
        double avgConcentration = 27200;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.VERY_UNHEALTHY.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.VERY_UNHEALTHY.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForCO.VERY_UNHEALTHY.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForCO.VERY_UNHEALTHY
                .getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnVeryUnhealthyAQILevel_When_AQINO2Is299() {
        pollutant = Pollutant.NO2;
        
        double avgConcentration = 1238;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.VERY_UNHEALTHY.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.VERY_UNHEALTHY.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForNO2.VERY_UNHEALTHY.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForNO2.VERY_UNHEALTHY
                .getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    /**
     * ----- Begin test for Hazardous Category level
     * ---------------------------------------------------------------------
     */
    
    @Test
    public void should_ReturnHazardousAQILevel_When_AQIPM10Is358() {
        pollutant = Pollutant.PM10;
        
        double avgConcentration = 470;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.HAZARDOUS.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.HAZARDOUS.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForPM10.HAZARDOUS.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForPM10.HAZARDOUS.getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnHazardousAQILevel_When_AQIPM25Is399() {
        pollutant = Pollutant.PM25;
        
        double avgConcentration = 349.3;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.HAZARDOUS.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.HAZARDOUS.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForPM25.HAZARDOUS.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForPM25.HAZARDOUS.getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnHazardousAQILevel_When_AQICOIs431() {
        pollutant = Pollutant.CO;
        
        double avgConcentration = 43500;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.HAZARDOUS.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.HAZARDOUS.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForCO.HAZARDOUS.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForCO.HAZARDOUS.getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnHazardousAQILevel_When_AQINO2Is500() {
        pollutant = Pollutant.NO2;
        
        double avgConcentration = 2044;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);
        
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        String expectedCategory = AQILevel.HAZARDOUS.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.HAZARDOUS.getMeaning();
        String expectedSpecificGuidanceMessage = AQILevelSpecificMessageForNO2.HAZARDOUS.getGuidance();
        String expectedHealthEffectsStatements = AQILevelSpecificMessageForNO2.HAZARDOUS.getHealthEffectsStatements();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(SensitiveGroups.getSensitiveGroups(pollutant), result.getSensitiveGroups());
    }
    
    /**
     * ----- Begin test for Invalid Concentration Range
     * ---------------------------------------------------------------------
     */
    
    @Test
    public void should_ReturnInvalidMessage_When_ConcentrationRangeExceeded() {
        pollutant = Pollutant.PM10;
        
        String expectedCategory = AQILevel.INVALID.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.INVALID.getMeaning();
        String expectedSpecificGuidanceMessage = NOT_APPLICABLE;
        String expectedHealthEffectsStatements = NOT_APPLICABLE;
        
        AQIResult result = calculator.getAQI(pollutant, -10);
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(NOT_APPLICABLE, result.getSensitiveGroups());
    }
    
    @Test
    public void should_ReturnInvalidMessage_When_ConcentrationRangeIsNegative() {
        pollutant = Pollutant.PM25;
        
        String expectedCategory = AQILevel.INVALID.getLiteral();
        String expectedMeaning = AQILevelGenericMessages.INVALID.getMeaning();
        String expectedSpecificGuidanceMessage = NOT_APPLICABLE;
        String expectedHealthEffectsStatements = NOT_APPLICABLE;
        
        AQIResult result = calculator.getAQI(pollutant, -1000000);
        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();
        
        assertEquals(expectedCategory, category);
        assertEquals(expectedMeaning, generalMessage);
        assertEquals(expectedSpecificGuidanceMessage, specificGuidanceMessage);
        assertEquals(expectedHealthEffectsStatements, healthEffectsStatements);
        assertEquals(NOT_APPLICABLE, result.getSensitiveGroups());
    }

    @Test
    public void should_ReturnCustomMessages_When_UserSettingIsEnable() {
        AQICustomSettings userSettings = new AQICustomSettings().withCustomMessagesMode(true)
                .withGeneralMessageResourcePath("AQIresource/custom-aqi-general-messages_de.json")
                .withSpecificMessageResourcePath("AQIresource/custom-aqi-specific-messages_de.json")
                .withSensitiveGroupsResourcePath("AQIresource/custom-aqi-sensitive-groups_de.json");
        calculator.applyCustomSettings(userSettings);

        pollutant = Pollutant.PM25;

        double avgConcentration = 197.9;
        AQIResult result = calculator.getAQI(pollutant, avgConcentration);

        category = result.getCategory();
        generalMessage = result.getMeaning();
        specificGuidanceMessage = result.getGuidanceStatement();
        healthEffectsStatements = result.getHealthEffectsStatement();

        String expectedCategory = "Sehr ungesund";
        String expectedMeaning = "Aktive Kinder und Erwachsene sowie Menschen mit Atemwegserkrankungen wie Asthma sollten jede Anstrengung im Freien vermeiden. Alle anderen, insbesondere Kinder, sollten die Belastung im Freien begrenzen";
        String expectedSpecificGuidanceMessage = "Menschen mit Herz- oder Lungenerkrankungen, ältere Erwachsene, Kinder und Menschen mit einem niedrigeren sozioökonomischen Status sollten jegliche körperliche Aktivität im Freien vermeiden. Alle anderen sollten eine längere oder schwere Anstrengung vermeiden";
        String expectedHealthEffectsStatements = "Signifikante Verschlechterung der Atemwegsbeschwerden in sensiblen Gruppen, einschließlich älterer Erwachsener, Kinder und Personen mit niedrigerem sozioökonomischen Status; signifikante Verschlechterung der Herz- oder Lungenerkrankung und vorzeitige Sterblichkeit bei Menschen mit Herz- oder Lungenerkrankung; signifikante Zunahme der Atemwegserkrankungen in der Allgemeinbevölkerung";
        String expectedSensitiveGroups = "Am stärksten gefährdet sind Menschen mit Atemwegs- oder Herzerkrankungen, ältere Menschen und Kinder";

        assertEquals(expectedCategory, result.getCategory());
        assertEquals(expectedMeaning, result.getMeaning());
        assertEquals(expectedHealthEffectsStatements, result.getHealthEffectsStatement());
        assertEquals(expectedSpecificGuidanceMessage, result.getGuidanceStatement());
        assertEquals(expectedSensitiveGroups, result.getSensitiveGroups());

        calculator.resetDefaultSettings();
    }
    
}
