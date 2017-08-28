package com.thanglequoc.aqicalculator;

public enum InvalidMessage {
    
    INVALID_CATEGORY("Uncategorized"),
    INVALID_GENERAL_MESSAGE("Invalid pollutant concentration range for calculation"),
    INVALID_HEALTH_EFFECTS_STATEMENTS_MESSAGE(""),
    INVALID_GUIDANCE_MESSAGE("");
    
    private String literal;
    
    InvalidMessage(String literal){
	this.literal = literal;
    }

    /**
     * @return the literal
     */
    public String getLiteral() {
        return literal;
    }
}
