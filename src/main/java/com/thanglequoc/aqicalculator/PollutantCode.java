package com.thanglequoc.aqicalculator;

/**
 * List of pollutant code.
 */
public enum PollutantCode {

    PM25("PM2.5"), 
    PM10("PM10"), 
    O3("O3"), 
    CO("CO"), 
    SO2("SO2"), 
    NO2("NO2");

    private String literal;

    PollutantCode(String literal) {
	this.literal = literal;
    }

    public String getLiteral() {
	return literal;
    }
    
}
