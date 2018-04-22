package com.thanglequoc.aqicalculator;

/**
 * List of pollutant code.
 */
public enum Pollutant {

    PM25("PM2.5"), 
    PM10("PM10"), 
    O3("O3"), 
    CO("CO"), 
    SO2("SO2"), 
    NO2("NO2");

    private String literal;

    Pollutant(String literal) {
	this.literal = literal;
    }

    public String getLiteral() {
	return literal;
    }
    
    public static Pollutant parseFromString(String text) {
	for (Pollutant pollutant : Pollutant.values()) {
	    if (pollutant.getLiteral().equals(text)) {
		return pollutant;
	    } 
	}
	return null;
    }
    
}
