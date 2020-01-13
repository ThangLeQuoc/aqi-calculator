package com.thanglequoc.aqicalculator;

/**
 * An object which store all necessary AQI result information, include
 * the<b>index</b> value, <b>category</b>, <b>health effects statements</b> and
 * <b>guidance message</b>,
 *
 * @author ThangLeQuoc
 */
public class AQIResult {
    
    private Pollutant pollutant;
    private double concentration;
    private int aqi;
    private String category;
    private String generalMessage;
    private String healthEffectsStatement;
    private String guidanceStatement;
    
    AQIResult(Pollutant pollutant, double concentration, int aqi, String category, String generalMessage,
              String healthEffectStatement, String guidanceStatement) {
        this.pollutant = pollutant;
        this.concentration = concentration;
        this.aqi = aqi;
        this.category = category;
        this.generalMessage = generalMessage;
        this.healthEffectsStatement = healthEffectStatement;
        this.guidanceStatement = guidanceStatement;
    }
    
    public Pollutant getPollutant() {
        return pollutant;
    }
    
    public int getAQI() {
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
    
    public double getConcentration() {
        return concentration;
    }
}
