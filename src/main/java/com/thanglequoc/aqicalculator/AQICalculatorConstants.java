package com.thanglequoc.aqicalculator;

class AQICalculatorConstants {
    
    /* JSON key constants */
    static final String INDEX = "index";
    static final String MIN = "min";
    static final String MAX = "max";
    static final String CATEGORY = "category";
    static final String MEANING = "meaning";
    static final String CAUTIONARY_STATEMENTS = "cautionaryStatements";
    static final String COLOR = "color";
    static final String CODE = "code";
    static final String UNIT = "unit";
    static final String PERIOD = "period";
    static final String AQI_LEVEL = "aqiLevel";
    static final String HEALTH_EFFECTS_STATEMENTS = "healthEffectsStatements";
    static final String CONCENTRATIONS = "concentrations";
    static final String SENSITIVE_GROUPS = "sensitiveGroups";
    
    /* Text for invalid AQI Stuffs */
    static final String UNCATEGORIZED = "Uncategorized";
    static final String INVALID_CONCENTRATION_RANGE_MSG = "Invalid pollutant concentration range for calculation";
    static final String NOT_APPLICABLE = "N/A";
    
    /* Resource Path */
    static final String AQI_BREAKPOINT_RESOURCE_PATH = "AQIresource/aqi-breakpoint.json";
    static final String AQI_GENERAL_MESSAGES_RESOURCE_PATH = "AQIresource/aqi-generic-messages.json";
    static final String AQI_SPECIFIC_MESSAGES_RESOURCE_PATH = "AQIresource/aqi-specific-messages.json";
    static final String AQI_SENSITIVE_GROUP_RESOURCE_PATH = "AQIresource/aqi-sensitive-groups.json";

    private AQICalculatorConstants() {
    
    }
}
