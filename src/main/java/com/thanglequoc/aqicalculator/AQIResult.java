package com.thanglequoc.aqicalculator;

/**
 * An object which store all necessary AQI result information, include
 * the<b>index</b> value, <b>category</b>, <b>health effects statements</b> and <b>guidance message</b>,
 * 
 * @author ThangLeQuoc
 * 
 */
public class AQIResult {

    /** <i>Air Quality Index</i>. */
    private int aqi;
    private String category;
    private String generalMessage;
    private String healthEffectsStatement;
    private String guidanceStatement;

    /**
     * @param aqi
     * @param category
     * @param generalMessage
     * @param healthEffectsStatement
     * @param guidanceStatement
     */
    AQIResult(int aqi, String category,  String generalMessage, String healthEffectStatement, String guidanceStatement) {
	this.aqi = aqi;
	this.category = category;
	this.generalMessage = generalMessage;
	this.healthEffectsStatement = healthEffectStatement;
	this.guidanceStatement = guidanceStatement;
    }

    /**
     * @return the aqi
     */
    public int getAqi() {
        return aqi;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }


    /**
     * @return the healthEffectsStatement
     */
    public String getHealthEffectsStatement() {
        return healthEffectsStatement;
    }

    /**
     * @return the guidanceStatement
     */
    public String getGuidanceStatement() {
        return guidanceStatement;
    }

    /**
     * @return the generalMessage
     */
    public String getGeneralMessage() {
        return generalMessage;
    }
}
