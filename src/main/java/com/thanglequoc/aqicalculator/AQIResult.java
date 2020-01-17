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
    private int AQI;
    private String category;
    private String color;
    private String meaning;
    private String healthEffectsStatement;
    private String guidanceStatement;
    private String sensitiveGroups;
    
    AQIResult(Pollutant pollutant, double concentration, int AQI, String category, String meaning, String color,
              String healthEffectStatement, String guidanceStatement, String sensitiveGroups) {
        this.pollutant = pollutant;
        this.concentration = concentration;
        this.AQI = AQI;
        this.category = category;
        this.meaning = meaning;
        this.color = color;
        this.healthEffectsStatement = healthEffectStatement;
        this.guidanceStatement = guidanceStatement;
        this.sensitiveGroups = sensitiveGroups;
    }
    
    public Pollutant getPollutant() {
        return pollutant;
    }

    /**
     * Get the Air Quality Index
     * */
    public int getAQI() {
        return AQI;
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
     * Get the meaning, health implications of this AQI level
     * */
    public String getMeaning() {
        return meaning;
    }

    /**
     * Get the concentration. If calculated from NowCast, this will be the NowCast concentration
     * */
    public double getConcentration() {
        return concentration;
    }

    /**
     * Get the specific color of this AQI level that assigned by EPA
     * */
    public String getColor() {
        return color;
    }

    /**
     * Get people that are sensitive to this pollutant
     * */
    public String getSensitiveGroups() {
       return sensitiveGroups;
    }
}
