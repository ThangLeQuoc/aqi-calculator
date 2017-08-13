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
     * Default Constructor
     */
    AQIResult() {
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
     * @param healthEffectStatement the healthEffectStatement to set
     */
    void setHealthEffectsStatement(String healthEffectsStatement) {
        this.healthEffectsStatement = healthEffectsStatement;
    }

    /**
     * @param guidanceStatement the guidanceStatement to set
     */
    void setGuidanceStatement(String guidanceStatement) {
        this.guidanceStatement = guidanceStatement;
    }

    /**
     * @return the generalMessage
     */
    String getGeneralMessage() {
        return generalMessage;
    }

    /**
     * @param generalMessage the generalMessage to set
     */
    void setGeneralMessage(String generalMessage) {
        this.generalMessage = generalMessage;
    }
    
    
    
    

}
