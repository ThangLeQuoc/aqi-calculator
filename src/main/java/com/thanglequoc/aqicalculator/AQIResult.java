package com.thanglequoc.aqicalculator;

/**
 * An object which store all necessary AQI result information, include
 * the<b>index</b> value, <b>category</b>, <b>health effects statements</b> and
 * <b>guidance message</b>,
 * 
 * @author ThangLeQuoc
 * 
 */
public class AQIResult {

    private int aqi;
    private String category;
    private String generalMessage;
    private String healthEffectsStatement;
    private String guidanceStatement;

    AQIResult(int aqi, String category, String generalMessage, String healthEffectStatement, String guidanceStatement) {
	this.aqi = aqi;
	this.category = category;
	this.generalMessage = generalMessage;
	this.healthEffectsStatement = healthEffectStatement;
	this.guidanceStatement = guidanceStatement;
    }

    public int getAqi() {
	return aqi;
    }

    public String getCategory() {
	return category;
    }

    public String getHealthEffectsStatement() {
	return healthEffectsStatement;
    }

    public String getGuidanceStatement() {
	return guidanceStatement;
    }

    public String getGeneralMessage() {
	return generalMessage;
    }
}
