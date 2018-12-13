package com.thanglequoc.aqicalculator;

/**
 * Object to store information for a specific pollutant code at different AQI
 * level
 *
 * @author ThangLeQuoc
 */
class SpecificAQILevelMessage {

    Index index;
    String category;
    String healthEffectsStatement;
    String guidance;

    SpecificAQILevelMessage(Index index, String category, String healthEffectsStatement, String guidance) {
        this.index = index;
        this.category = category;
        this.healthEffectsStatement = healthEffectsStatement;
        this.guidance = guidance;
    }

    Index getIndex() {
        return index;
    }

    String getCategory() {
        return category;
    }

    String getHealthEffectsStatements() {
        return healthEffectsStatement;
    }

    String getGuidance() {
        return guidance;
    }

}
