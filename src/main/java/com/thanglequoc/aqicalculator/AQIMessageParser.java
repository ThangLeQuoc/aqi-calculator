package com.thanglequoc.aqicalculator;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

class AQIMessageParser {
    
    GeneralAQIInformation parseGeneralAQIInformationNode(JsonNode generalInfoNode) {
        String category = generalInfoNode.path(AQICalculatorConstants.CATEGORY).asText();
        String meaning = generalInfoNode.path(AQICalculatorConstants.MEANING).asText();
        String color = generalInfoNode.path(AQICalculatorConstants.COLOR).asText();
        Index index = Index.fromIndexNode(generalInfoNode.path(AQICalculatorConstants.INDEX));
        return new GeneralAQIInformation(index, category, meaning, color);
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

    SensitiveGroups parseSensitiveGroupInformationNode(JsonNode sensitiveGroupsNode) {
        String pollutantCode = sensitiveGroupsNode.path(AQICalculatorConstants.CODE).asText();
        Pollutant pollutant = Pollutant.parseFromString(pollutantCode);
        String sensitiveGroups = sensitiveGroupsNode.path(AQICalculatorConstants.SENSITIVE_GROUPS).asText();
        return new SensitiveGroups(pollutant, sensitiveGroups);
    }
    
    private SpecificAQILevelMessage parseLevelMessageFromNode(JsonNode levelMessageNode) {
        String category = levelMessageNode.path(AQICalculatorConstants.CATEGORY).asText();
        String healthEffectsStatements = levelMessageNode.path(AQICalculatorConstants.HEALTH_EFFECTS_STATEMENTS)
                .asText();
        String cautionaryStatements = levelMessageNode.path(AQICalculatorConstants.CAUTIONARY_STATEMENTS).asText();
        Index index = Index.fromIndexNode(levelMessageNode.path(AQICalculatorConstants.INDEX));
        return new SpecificAQILevelMessage(index, category, healthEffectsStatements, cautionaryStatements);
    }
    
}
