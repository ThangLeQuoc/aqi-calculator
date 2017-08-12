package com.thanglequoc.aqicalculator;

/**
 * An object which store all necessary AQI result information, include
 * the<b>index</b> value, <b>category</b>, <b>guidance message</b>,
 * 
 * @author ThangLeQuoc
 * 
 */
public class AQIResult {

    /**
     * <i>Air Quality Index</i>
     */
    private int aqi;
    private String category;
    private String message;
    private String healthAffectStatement;
    private String guidanceStatement;

    /**
     * @param aqi
     * @param category
     * @param message
     * @param healthAffectStatement
     * @param guidanceStatement
     */
    AQIResult(int aqi, String category, String message, String healthAffectStatement, String guidanceStatement) {
	this.aqi = aqi;
	this.category = category;
	this.message = message;
	this.healthAffectStatement = healthAffectStatement;
	this.guidanceStatement = guidanceStatement;
    }

    /**
     * Default Constructor
     */
    AQIResult() {
    }

    /**
     * @return the aqi
     */
    int getAqi() {
        return aqi;
    }

    /**
     * @return the category
     */
    String getCategory() {
        return category;
    }

    /**
     * @return the message
     */
    String getMessage() {
        return message;
    }

    /**
     * @return the healthAffectStatement
     */
    String getHealthAffectStatement() {
        return healthAffectStatement;
    }

    /**
     * @return the guidanceStatement
     */
    String getGuidanceStatement() {
        return guidanceStatement;
    }

    /**
     * @param aqi the aqi to set
     */
    void setAqi(int aqi) {
        this.aqi = aqi;
    }

    /**
     * @param category the category to set
     */
    void setCategory(String category) {
        this.category = category;
    }

    /**
     * @param message the message to set
     */
    void setMessage(String message) {
        this.message = message;
    }

    /**
     * @param healthAffectStatement the healthAffectStatement to set
     */
    void setHealthAffectStatement(String healthAffectStatement) {
        this.healthAffectStatement = healthAffectStatement;
    }

    /**
     * @param guidanceStatement the guidanceStatement to set
     */
    void setGuidanceStatement(String guidanceStatement) {
        this.guidanceStatement = guidanceStatement;
    }
    
    

}
