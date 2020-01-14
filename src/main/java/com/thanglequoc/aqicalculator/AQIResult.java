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

    /**
     * Get the Air Quality Index
     * */
    public int getAQI() {
        return aqi;
    }

    /**
     * Get the Air Quality Category
     * */
    public String getCategory() {
        return category;
    }

    /**
     * Get the Health Effects Statement
     * */
    public String getHealthEffectsStatement() {
        return healthEffectsStatement;
    }

    /**
     * Get the Guidance Statement for this pollutant at this category level
     * */
    public String getGuidanceStatement() {
        return guidanceStatement;
    }

    /**
     * Get the general AIR at this category level
     * */
    public String getGeneralMessage() {
        return generalMessage;
    }

    /**
     * Get the concentration. If calculated from NowCast, this will be the NowCast concentration
     * */
    public double getConcentration() {
        return concentration;
    }
}
