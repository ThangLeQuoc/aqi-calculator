package com.thanglequoc.aqicalculator.aqi;

public enum AQILevelSpecificMessageForO3 {
   
    GOOD("None","None"),
    MODERATE("Unusually sensitive individuals may experience respiratory symptoms","Unusually sensitive people should consider reducing prolonged or heavy outdoor exertion"),
    UNHEALTHY_FOR_SENSITIVE_GROUPS("Increasing likelihood of respiratory symptoms and breathing discomfort in people with lung disease (such as asthma), children, older adults, people who are active outdoors (including outdoor workers), people with certain genetic variants, and people with diets limited in certain nutrients","People with lung disease (such as asthma), children, older adults, people who are active outdoors (including outdoor workers), people with certain genetic variants, and people with diets limited in certain nutrients should reduce prolonged or heavy outdoor exertion"),
    UNHEALTHY("Greater likelihood of respiratory symptoms and breathing in people with lung disease (such as asthma), children, older adults, people who are active outdoors (including outdoor workers), people with certain genetic variants, and people with diets limited in certain nutrients; possible respiratory effects in general population","People with lung disease (such as asthma), children, older adults, people who are active outdoors (including outdoor workers), people with certain genetic variants, and people with diets limited in certain nutrients should avoid prolonged or heavy outdoor exertion; everyone else should reduce prolonged or heavy outdoor exertion"),
    VERY_UNHEALTHY("Increasingly severe symptoms and impaired breathing likely in people with lung disease (such as asthma), children, older adults, people who are active outdoors (including outdoor workers), people with certain genetic variants, and people with diets limited in certain nutrients; increasing likelihood of respiratory effects in general population","People with lung disease (such as asthma), children, older adults, people who are active outdoors (including outdoor workers), people with certain genetic variants, and people with diets limited in certain nutrients should avoid all outdoor exertion; everyone else should reduce outdoor exertion"),
    HAZARDOUS("Severe respiratory effects and impaired breathing likely in people with lung disease (such as asthma), children, older adults, people who are active outdoors (including outdoor workers), people with certain genetic variants, and people with diets limited in certain nutrients; increasingly severe respiratory effects likely in general population","Everyone should avoid all outdoor exertion");
    
    private String healthEffectsStatements;
    private String guidance;
    
    
    AQILevelSpecificMessageForO3(String healthEffectsStatements, String guidance){
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
