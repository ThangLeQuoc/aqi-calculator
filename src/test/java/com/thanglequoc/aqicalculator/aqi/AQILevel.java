package com.thanglequoc.aqicalculator.aqi;

public enum AQILevel {
    
    GOOD("Good"),
    
    MODERATE("Moderate"),
    
    UNHEALTHY_FOR_SENSITIVE_GROUPS("Unhealthy for Sensitive Groups"),
   
    UNHEALTHY("Unhealthy"),
    
    VERY_UNHEALTHY("Very Unhealthy"),
    
    HAZARDOUS("Hazardous");
    
    /** The literal. */
	private String literal;
    
	
    AQILevel(String literal){
	this.literal = literal;
    }
    
    public String getLiteral(){
	return literal;
    }
}



