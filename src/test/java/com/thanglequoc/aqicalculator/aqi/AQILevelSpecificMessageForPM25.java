package com.thanglequoc.aqicalculator.aqi;

public enum AQILevelSpecificMessageForPM25 {
    GOOD("None","None"),
    MODERATE("Respiratory symptoms possible in unusually sensitive individuals; possible aggravation of heart or lung disease in people with cardiopulmonary disease and older adults","Unusually sensitive people should consider reducing prolonged or heavy exertion"),
    UNHEALTHY_FOR_SENSITIVE_GROUPS("Increasing likelihood of respiratory symptoms in sensitive groups including older adults, children, and people of lower socioeconomic status; aggravation of heart or lung disease and premature mortality in people with heart or lung disease","People with heart or lung disease, older adults, children, and people of lower socioeconomic status should reduce prolonged or heavy exertion"),
    UNHEALTHY("Increased aggravation of respiratory symptoms in sensitive groups including older adults, children, and people of lower socioeconomic status; increased aggravation of heart or lung disease and premature mortality in people with heart or lung disease; increased respiratory effects in general population","People with heart or lung disease, older adults, children, and people of lower socioeconomic status should avoid prolonged or heavy exertion; everyone else should reduce prolonged or heavy exertion"),
    VERY_UNHEALTHY("Significant aggravation of respiratory symptoms in sensitive groups including older adults, children, and people of lower socioeconomic status; significant aggravation of heart or lung disease and premature mortality in people with heart or lung disease; significant increase in respiratory effects in general population","People with heart or lung disease, older adults, children, and people of lower socioeconomic status should avoid all physical activity outdoors. Everyone else should avoid prolonged or heavy exertion"),
    HAZARDOUS("Serious aggravation of respiratory symptoms in sensitive groups including older adults, children, and people of lower socioeconomic status; serious aggravation of heart or lung disease and premature mortality in people with heart or lung disease; serious risk of respiratory effects in general population","Everyone should avoid all physical activity outdoors; people with heart or lung disease, older adults, children, and people of lower socioeconomic status should remain indoors and keep activity levels low");
    
    private String healthEffectsStatements;
    private String guidance;
    
    
    AQILevelSpecificMessageForPM25(String healthEffectsStatements, String guidance){
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
