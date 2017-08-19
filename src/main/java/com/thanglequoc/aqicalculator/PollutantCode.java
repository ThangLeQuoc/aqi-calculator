package com.thanglequoc.aqicalculator;

// TODO: Auto-generated Javadoc
/**
 * The Enum PollutantCode.
 */
public enum PollutantCode {
	
	/** The pm25. */
	PM25("PM2.5"), 
	
	/** The pm10. */
	PM10("PM10"),
	
	/** The o3. */
	O3("O3"),
	
	/** The co. */
	CO("CO"),
	
	/** The so2. */
	SO2("SO2"),
	
	/** The no2. */
	NO2("NO2");
	
	/** The literal. */
	private String literal;
	
	/**
	 * Instantiates a new pollutant code.
	 *
	 * @param literal the literal
	 */
	PollutantCode(String literal) {
		this.literal = literal;
	}
	
	/**
	 * Gets the literal.
	 *
	 * @return the literal
	 */
	public String getLiteral() {
		return literal;
	}
}
