package com.thanglequoc.aqicalculator;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

class AQIMessageGenerator {

    private List<GeneralAQIMessage> generalAQIMessages;
    private List<SpecificAQIMessage> specificAQIMessages;

    AQIMessageGenerator() throws IOException {
	ObjectMapper mapper = new ObjectMapper();
	ClassLoader classLoader = AQIMessageGenerator.class.getClassLoader();
	generalAQIMessages = new ArrayList<>();
	specificAQIMessages = new ArrayList<>();
	AQIMessageParser msgParser = new AQIMessageParser();

	initializeMessageResources(mapper, classLoader, msgParser);
    }

    private void initializeMessageResources(ObjectMapper mapper, ClassLoader classLoader, AQIMessageParser msgParser)
	    throws IOException, JsonProcessingException {
	try (InputStream specificAQIMessagesStream = classLoader
		.getResourceAsStream(AQICalculatorConstants.AQI_SPECIFIC_MESSAGES_RESOURCE_PATH);
		InputStream generalAQIMessageStream = classLoader
			.getResourceAsStream(AQICalculatorConstants.AQI_GENERAL_MESSAGES_RESOURCE_PATH);) {

	    /* Parse General Message Node */
	    JsonNode generalMessageNodeRoot = mapper.readTree(generalAQIMessageStream);
	    for (JsonNode generalMessageNode : generalMessageNodeRoot) {
		GeneralAQIMessage generalAQIMessage = msgParser.parseGeneralMessageNode(generalMessageNode);
		generalAQIMessages.add(generalAQIMessage);
	    }

	    /* Parse Specific Message Node */
	    JsonNode specificMessageNodeRoot = mapper.readTree(specificAQIMessagesStream);
	    for (JsonNode specificMessageNode : specificMessageNodeRoot) {
		SpecificAQIMessage specificAQIMessage = msgParser.parseSpecificAQIMessageNode(specificMessageNode);
		specificAQIMessages.add(specificAQIMessage);
	    }
	}
    }

    GeneralAQIMessage getGeneralAQIMessageObjectOnAQILevel(int AQI) {
	for (GeneralAQIMessage generalAQIMessage : generalAQIMessages) {
	    if (generalAQIMessage.getIndex().getMinIndex() <= AQI && generalAQIMessage.getIndex().getMaxIndex() >= AQI)
		return generalAQIMessage;
	}
	return null;
    }

    SpecificAQILevelMessage getSpecifcAQILevelMessageOnAQILevelOfPollutant(Pollutant pollutant, int AQI) {
	for (SpecificAQIMessage specificAQIMessage : specificAQIMessages) {
	    if (specificAQIMessage.getPollutant().equals(pollutant)) {
		SpecificAQIMessage targetPollutantMessage = specificAQIMessage;

		for (SpecificAQILevelMessage specificAQILevelMessage : targetPollutantMessage.getLevelMessages()) {
		    if (specificAQILevelMessage.getIndex().getMinIndex() <= AQI
			    && specificAQILevelMessage.getIndex().getMaxIndex() >= AQI)
			return specificAQILevelMessage;
		}
	    }
	}

	return null;
    }

}
