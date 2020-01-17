package com.thanglequoc.aqicalculator.aqi;

enum AQILevelSpecificMessageForCO {
    GOOD("None", "None"),
    MODERATE("None", "None"),
    UNHEALTHY_FOR_SENSITIVE_GROUPS("Increasing likelihood of reduced exercise tolerance due to increased cardiovascular symptoms, such as chest pain, in people with heart disease", "People with heart disease, such as angina, should limit heavy exertion and avoid sources of CO, such as heavy traffic"),
    UNHEALTHY("Reduced exercise tolerance due to increased cardiovascular symptoms, such as chest pain, in people with heart disease", "People with heart disease, such as angina, should limit moderate exertion and avoid sources of CO, such as heavy traffic"),
    VERY_UNHEALTHY("Significant aggravation of cardiovascular symptoms, such as chest pain, in people with heart disease", "People with heart disease, such as angina, should avoid exertion and sources of CO, such as heavy traffic"),
    HAZARDOUS("Serious aggravation of cardiovascular symptoms, such as chest pain, in people with heart disease; impairment of strenuous activities in general population", "People with heart disease, such as angina, should avoid exertion and sources of CO, such as heavy traffic; everyone else should limit heavy exertion");
    
    private String healthEffectsStatements;
    private String guidance;
    
    
    AQILevelSpecificMessageForCO(String healthEffectsStatements, String guidance) {
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
