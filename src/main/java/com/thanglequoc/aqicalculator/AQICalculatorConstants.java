package com.thanglequoc.aqicalculator;

class AQICalculatorConstants {
    
    /* JSON key constants */
    static final String INDEX = "index";
    static final String MIN = "min";
    static final String MAX = "max";
    static final String CATEGORY = "category";
    static final String GUIDANCE = "guidance";
    static final String CODE = "code";
    static final String UNIT = "unit";
    static final String PERIOD = "period";
    static final String AQI_LEVEL = "aqiLevel";
    static final String HEALTH_EFFECTS_STATEMENT = "healthEffectsStatement";
    static final String CONCENTRATIONS = "concentrations";
    
    /* Text for invalid AQI Stuffs */
    static final String UNCATEGORIZED = "Uncategorized";
    static final String INVALID_GENERAL_MESSAGE = "Invalid pollutant concentration range for calculation";
    static final String NONE = "None";
    
    /* Resource Path */
    static final String AQI_BREAKPOINT_RESOURCE_PATH = "AQIresource/aqi-breakpoint.json";
    static final String AQI_GENERAL_MESSAGES_RESOURCE_PATH = "AQIresource/aqi-general-messages.json";
    static final String AQI_SPECIFIC_MESSAGES_RESOURCE_PATH = "AQIresource/aqi-specific-messages.json";
    
    private AQICalculatorConstants() {
    
    }
}
