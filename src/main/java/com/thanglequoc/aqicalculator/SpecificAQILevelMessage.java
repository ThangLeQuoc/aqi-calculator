package com.thanglequoc.aqicalculator;

/**
 * Object to store information for a specifc pollutant code at diferrent AQI level
 * 
 * @author ThangLeQuoc
 * */
public class SpecificAQILevelMessage {
    Index index;
    String category;
    String healthEffectsStatements;
    String guidance;
    
    
    
    
    /**
     * @param index
     * @param category
     * @param healthEffectsStatements
     * @param guidance
     */
    SpecificAQILevelMessage(Index index, String category, String healthEffectsStatements, String guidance) {
	super();
	this.index = index;
	this.category = category;
	this.healthEffectsStatements = healthEffectsStatements;
	this.guidance = guidance;
    }
    
    
    /**
     * @return the index
     */
    Index getIndex() {
        return index;
    }
    /**
     * @return the category
     */
    String getCategory() {
        return category;
    }
    /**
     * @return the healthEffectsStatements
     */
    String getHealthEffectsStatements() {
        return healthEffectsStatements;
    }
    /**
     * @return the guidance
     */
    String getGuidance() {
        return guidance;
    }   
}
