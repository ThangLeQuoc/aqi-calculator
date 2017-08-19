package com.thanglequoc.aqicalculator.aqi;

public enum AQILevelSpecificMessageForNO2 {
    GOOD("None","None"),
    MODERATE("None","Unusually sensitive individuals should consider limiting prolonged exertion especially near busy roads"),
    UNHEALTHY_FOR_SENSITIVE_GROUPS("Increasing likelihood of respiratory symptoms, such as chest tightness and breathing discomfort, in people with asthma","People with asthma, children and older adults should limit prolonged exertion especially near busy roads"),
    UNHEALTHY("Increased respiratory symptoms, such as chest tightness and wheezing in people with asthma; possible aggravation of other lung diseases","People with asthma, children and older adults should avoid prolonged exertion near roadways; everyone else should limit prolonged exertion especially near busy roads"),
    VERY_UNHEALTHY("Significant increase in respiratory symptoms, such as wheezing and shortness of breath, in people with asthma; aggravation of other lung diseases","People with asthma, children and older adults should avoid all outdoor exertion; everyone else should avoid prolonged exertion especially near busy roads"),
    HAZARDOUS("Severe respiratory symptoms, such as wheezing and shortness of breath, in people with asthma; increased aggravation of other lung diseases; possible respiratory effects in general population","People with asthma, children and older adults should remain indoors; everyone else should avoid all outdoor exertion");
    
    private String healthEffectsStatements;
    private String guidance;
    
    
    AQILevelSpecificMessageForNO2(String healthEffectsStatements, String guidance){
	this.healthEffectsStatements = healthEffectsStatements;
	this.guidance = guidance;
    }
    
    public String getHealthEffectsStatements(){
	return healthEffectsStatements;
    }
    
    public String getGuidance(){
	return guidance;
    }
}
