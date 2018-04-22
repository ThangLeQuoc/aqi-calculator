package com.thanglequoc.aqicalculator;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

class AQIMessageParser {

    GeneralAQIMessage parseGeneralMessageNode(JsonNode generalMsgNode) {
	
	String category = generalMsgNode.path(AQICalculatorConstants.CATEGORY).asText();
	String guidance = generalMsgNode.path(AQICalculatorConstants.GUIDANCE).asText();
	Index index = parseIndexNode(generalMsgNode);	
	return new GeneralAQIMessage(index, category, guidance);
    }
    
    SpecificAQIMessage parseSpecificAQIMessageNode(JsonNode specificMsgNode) {
	
	List<SpecificAQILevelMessage> specificAQILevelMessages = new ArrayList<>();
	String pollutantCode = specificMsgNode.path(AQICalculatorConstants.CODE).asText();
	
	JsonNode specificLevelMessagesNode = specificMsgNode.path(AQICalculatorConstants.AQI_LEVEL);
	for (JsonNode aqiLevelMessageNode: specificLevelMessagesNode) {
	    String category = aqiLevelMessageNode.path(AQICalculatorConstants.CATEGORY).asText();
	    String healthEffectsStatements = aqiLevelMessageNode.path(AQICalculatorConstants.HEALTH_EFFECTS_STATEMENT).asText();
	    String guidance = aqiLevelMessageNode.path(AQICalculatorConstants.GUIDANCE).asText();
	    Index index = parseIndexNode(aqiLevelMessageNode);
	    SpecificAQILevelMessage levelMessage = new SpecificAQILevelMessage(index, category, healthEffectsStatements, guidance);
	    specificAQILevelMessages.add(levelMessage);
	}
	
	return new SpecificAQIMessage(pollutantCode, specificAQILevelMessages);
    }
    
    private Index parseIndexNode(JsonNode node) {
	int minIndex = node.path(AQICalculatorConstants.INDEX).path(AQICalculatorConstants.MIN).asInt();
	int maxIndex = node.path(AQICalculatorConstants.INDEX).path(AQICalculatorConstants.MAX).asInt();
	return new Index(minIndex, maxIndex);
    }

}
