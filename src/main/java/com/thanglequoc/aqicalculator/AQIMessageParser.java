package com.thanglequoc.aqicalculator;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * The Class GeneralAQIMessageParser.
 */
public class AQIMessageParser {

    /**
     * Parses the general message node.
     *
     * @param generalMsgNode the general msg node
     * @return the general AQI message
     */
    GeneralAQIMessage parseGeneralMessageNode(JsonNode generalMsgNode) {
	String category = generalMsgNode.path("category").asText();
	String guidance = generalMsgNode.path("guidance").asText();
	
	int minIndex = generalMsgNode.path("index").path("min").asInt();
	int maxIndex = generalMsgNode.path("index").path("max").asInt();
	Index index =new Index(minIndex, maxIndex);
	
	GeneralAQIMessage generalAQIMessage = new GeneralAQIMessage(index, category, guidance);
	return generalAQIMessage;
    }
    
    SpecificAQIMessage parseSpecificAQIMessageNode(JsonNode specificMsgNode){
	String pollutantCode = specificMsgNode.path("code").asText();
	List<SpecificAQILevelMessage> specificAQILevelMessages = new ArrayList<SpecificAQILevelMessage>();
	
	JsonNode specificAQLLevelMessagesNode = specificMsgNode.path("aqiLevel");
	for(JsonNode aqiLevelMessageNode: specificAQLLevelMessagesNode){
	    String category = aqiLevelMessageNode.path("category").asText();
	    String healthEffectsStatements = aqiLevelMessageNode.path("healthEffectsStatements").asText();
	    String guidance = aqiLevelMessageNode.path("guidance").asText();
	    
	    int minIndex = aqiLevelMessageNode.path("index").path("min").asInt();
	    int maxIndex = aqiLevelMessageNode.path("index").path("max").asInt();
	    Index index = new Index(minIndex, maxIndex);
	    
	    SpecificAQILevelMessage levelMessage = new SpecificAQILevelMessage(index, category, healthEffectsStatements, guidance);
	    specificAQILevelMessages.add(levelMessage);
	}
	
	return new SpecificAQIMessage(pollutantCode, specificAQILevelMessages);
    }

}
