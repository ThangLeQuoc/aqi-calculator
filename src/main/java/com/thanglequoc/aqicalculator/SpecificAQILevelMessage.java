package com.thanglequoc.aqicalculator;

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
    /**
     * @param index the index to set
     */
    void setIndex(Index index) {
        this.index = index;
    }
    /**
     * @param category the category to set
     */
    void setCategory(String category) {
        this.category = category;
    }
    /**
     * @param healthEffectsStatements the healthEffectsStatements to set
     */
    void setHealthEffectsStatements(String healthEffectsStatements) {
        this.healthEffectsStatements = healthEffectsStatements;
    }
    /**
     * @param guidance the guidance to set
     */
    void setGuidance(String guidance) {
        this.guidance = guidance;
    }
    
    
}
