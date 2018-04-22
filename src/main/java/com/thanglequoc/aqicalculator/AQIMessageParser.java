package com.thanglequoc.aqicalculator;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

class AQIMessageParser {

    GeneralAQIMessage parseGeneralMessageNode(JsonNode generalMsgNode) {
	
	String category = generalMsgNode.path(AQIResourcePathConstants.CATEGORY).asText();
	String guidance = generalMsgNode.path(AQIResourcePathConstants.GUIDANCE).asText();
	Index index = parseIndexNode(generalMsgNode);	
	return new GeneralAQIMessage(index, category, guidance);
    }
    
    SpecificAQIMessage parseSpecificAQIMessageNode(JsonNode specificMsgNode) {
	
	List<SpecificAQILevelMessage> specificAQILevelMessages = new ArrayList<>();
	String pollutantCode = specificMsgNode.path(AQIResourcePathConstants.CODE).asText();
	
	JsonNode specificLevelMessagesNode = specificMsgNode.path(AQIResourcePathConstants.AQI_LEVEL);
	for (JsonNode aqiLevelMessageNode: specificLevelMessagesNode) {
	    String category = aqiLevelMessageNode.path(AQIResourcePathConstants.CATEGORY).asText();
	    String healthEffectsStatements = aqiLevelMessageNode.path(AQIResourcePathConstants.HEALTH_EFFECTS_STATEMENT).asText();
	    String guidance = aqiLevelMessageNode.path(AQIResourcePathConstants.GUIDANCE).asText();
	    Index index = parseIndexNode(aqiLevelMessageNode);
	    SpecificAQILevelMessage levelMessage = new SpecificAQILevelMessage(index, category, healthEffectsStatements, guidance);
	    specificAQILevelMessages.add(levelMessage);
	}
	
	return new SpecificAQIMessage(pollutantCode, specificAQILevelMessages);
    }
    
    private Index parseIndexNode(JsonNode node) {
	int minIndex = node.path(AQIResourcePathConstants.INDEX).path(AQIResourcePathConstants.MIN).asInt();
	int maxIndex = node.path(AQIResourcePathConstants.INDEX).path(AQIResourcePathConstants.MAX).asInt();
	return new Index(minIndex, maxIndex);
    }

}
