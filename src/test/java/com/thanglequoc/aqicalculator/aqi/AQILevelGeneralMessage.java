package com.thanglequoc.aqicalculator.aqi;

public enum AQILevelGeneralMessage {
    INVALID("Invalid pollutant concentration range for calculation"),
    GOOD("None"),
    MODERATE("Unusually sensitive people should consider reducing prolonged or heavy outdoor exertion"),
    UNHEALTHY_FOR_SENSITIVE_GROUPS("Active children and adults, and people with respiratory disease, such as asthma, should limit prolonged outdoor exertion"),
    UNHEALTHY("Active children and adults, and people with respiratory disease, such as asthma, should avoid prolonged outdoor exertion; everyone else, especially children, should limit prolonged outdoor exertion"),
    VERY_UNHEALTHY("Active children and adults, and people with respiratory disease, such as asthma, should avoid all outdoor exertion; everyone else, especially children, should limit outdoor exertion"),
    HAZARDOUS("Everyone should avoid all outdoor exertion");
    
    
    private String meaning;
    
    AQILevelGeneralMessage(String meaning) {
        this.meaning = meaning;
    }
    
    /**
     * Gets the general guidance message.
     *
     * @return the general guidance message
     */
    public String getMeaning() {
        return meaning;
    }
}
