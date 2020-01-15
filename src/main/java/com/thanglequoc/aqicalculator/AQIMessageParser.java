package com.thanglequoc.aqicalculator;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

class AQIMessageParser {
    
    GenericAQIInformation parseGenericAQIInformationNode(JsonNode genericInfoNode) {
        String category = genericInfoNode.path(AQICalculatorConstants.CATEGORY).asText();
        String meaning = genericInfoNode.path(AQICalculatorConstants.MEANING).asText();
        String color = genericInfoNode.path(AQICalculatorConstants.COLOR).asText();
        Index index = Index.fromIndexNode(genericInfoNode.path(AQICalculatorConstants.INDEX));
        return new GenericAQIInformation(index, category, meaning, color);
    }
    
    SpecificAQIInformation parseSpecificAQIMessageNode(JsonNode specificInfoNode) {
        List<SpecificAQILevelMessage> specificAQILevelMessages = new ArrayList<>();
        String pollutantCode = specificInfoNode.path(AQICalculatorConstants.CODE).asText();
        Pollutant pollutant = Pollutant.parseFromString(pollutantCode);
        JsonNode specificLevelMessagesNode = specificInfoNode.path(AQICalculatorConstants.AQI_LEVEL);
        for (JsonNode aqiLevelMessageNode : specificLevelMessagesNode) {
            SpecificAQILevelMessage levelMessage = parseLevelMessageFromNode(aqiLevelMessageNode);
            specificAQILevelMessages.add(levelMessage);
        }
        return new SpecificAQIInformation(pollutant, specificAQILevelMessages);
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
