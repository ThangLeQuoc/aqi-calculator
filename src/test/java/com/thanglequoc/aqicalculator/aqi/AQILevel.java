package com.thanglequoc.aqicalculator.aqi;

enum AQILevel {
    
    INVALID("Uncategorized", "N/A"),
    
    GOOD("Good", "Green"),
    
    MODERATE("Moderate", "Yellow"),
    
    UNHEALTHY_FOR_SENSITIVE_GROUPS("Unhealthy for Sensitive Groups", "Orange"),
    
    UNHEALTHY("Unhealthy","Red"),
    
    VERY_UNHEALTHY("Very Unhealthy","Purple"),
    
    HAZARDOUS("Hazardous", "Maroon");
    
    /**
     * The literal.
     */
    private String literal;

    private String color;
    
    
    AQILevel(String literal, String color) {
        this.literal = literal;
        this.color = color;
    }
    
    public String getLiteral() {
        return literal;
    }

    public String getColor() {
        return color;
    }
}



