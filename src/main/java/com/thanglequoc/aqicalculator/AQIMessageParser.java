package com.thanglequoc.aqicalculator;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

class AQIMessageParser {

    GeneralAQIMessage parseGeneralMessageNode(JsonNode generalMsgNode) {
	String category = generalMsgNode.path(AQICalculatorConstants.CATEGORY).asText();
	String guidance = generalMsgNode.path(AQICalculatorConstants.GUIDANCE).asText();
	Index index = Index.fromIndexNode(generalMsgNode.path(AQICalculatorConstants.INDEX));
	return new GeneralAQIMessage(index, category, guidance);
    }

    SpecificAQIMessage parseSpecificAQIMessageNode(JsonNode specificMsgNode) {
	List<SpecificAQILevelMessage> specificAQILevelMessages = new ArrayList<>();
	String pollutantCode = specificMsgNode.path(AQICalculatorConstants.CODE).asText();
	Pollutant pollutant = Pollutant.parseFromString(pollutantCode);
	JsonNode specificLevelMessagesNode = specificMsgNode.path(AQICalculatorConstants.AQI_LEVEL);
	for (JsonNode aqiLevelMessageNode : specificLevelMessagesNode) {
	    SpecificAQILevelMessage levelMessage = parseLevelMessageFromNode(aqiLevelMessageNode);
	    specificAQILevelMessages.add(levelMessage);
	}
	return new SpecificAQIMessage(pollutant, specificAQILevelMessages);
    }

    private SpecificAQILevelMessage parseLevelMessageFromNode(JsonNode levelMessageNode) {
	String category = levelMessageNode.path(AQICalculatorConstants.CATEGORY).asText();
	String healthEffectsStatements = levelMessageNode.path(AQICalculatorConstants.HEALTH_EFFECTS_STATEMENT)
		.asText();
	String guidance = levelMessageNode.path(AQICalculatorConstants.GUIDANCE).asText();
	Index index = Index.fromIndexNode(levelMessageNode.path(AQICalculatorConstants.INDEX));
	return new SpecificAQILevelMessage(index, category, healthEffectsStatements, guidance);
    }

}
