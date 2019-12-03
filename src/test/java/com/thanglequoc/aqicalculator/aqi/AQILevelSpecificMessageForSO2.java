package com.thanglequoc.aqicalculator.aqi;

public enum AQILevelSpecificMessageForSO2 {
    GOOD("None", "None"),
    MODERATE("None", "None"),
    UNHEALTHY_FOR_SENSITIVE_GROUPS("Increasing likelihood of respiratory symptoms, such as chest tightness and breathing discomfort, in people with asthma", "People with asthma should consider limiting outdoor exertion"),
    UNHEALTHY("Increased respiratory symptoms, such as chest tightness and wheezing in people with asthma; possible aggravation of other lung diseases", "Children, people with asthma, or other lung diseases, should limit outdoor exertion"),
    VERY_UNHEALTHY("Significant increase in respiratory symptoms, such as wheezing and shortness of breath, in people with asthma; aggravation of other lung diseases", "Children, people with asthma, or other lung diseases should avoid outdoor exertion; everyone else should reduce outdoor exertion"),
    HAZARDOUS("Severe respiratory symptoms, such as wheezing and shortness of breath, in people with asthma; increased aggravation of other lung diseases; possible respiratory effects in general population", "Children, people with asthma, or other lung diseases, should remain indoors; everyone else should avoid outdoor exertion");
    
    private String healthEffectsStatements;
    private String guidance;
    
    
    AQILevelSpecificMessageForSO2(String healthEffectsStatements, String guidance) {
        this.healthEffectsStatements = healthEffectsStatements;
        this.guidance = guidance;
    }
    
    public String getHealthEffectsStatements() {
        return healthEffectsStatements;
    }
    
    public String getGuidance() {
        return guidance;
    }
}
