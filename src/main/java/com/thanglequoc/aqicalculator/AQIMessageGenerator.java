package com.thanglequoc.aqicalculator;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

class AQIMessageGenerator {

    private static String generalMessagesPath = "AQIresource/aqi-general-messages.json";
    private static String specificMessagesPath = "AQIresource/aqi-specific-messages.json";

    private List<GeneralAQIMessage> generalAQIMessages;
    private List<SpecificAQIMessage> specificAQIMessages;

    AQIMessageGenerator() throws IOException {
	ObjectMapper mapper = new ObjectMapper();
	ClassLoader classLoader = AQIMessageGenerator.class.getClassLoader();
	generalAQIMessages = new ArrayList<>();
	specificAQIMessages = new ArrayList<>();

	AQIMessageParser msgParser = new AQIMessageParser();

	try (InputStream specificAQIMessagesStream = classLoader.getResourceAsStream(specificMessagesPath);
		InputStream generalAQIMessageStream = classLoader.getResourceAsStream(generalMessagesPath);) {

	    /* Parse General Message Node */
	    JsonNode specificMessageNodeRoot = mapper.readTree(specificAQIMessagesStream);
	    JsonNode generalMessageNodeRoot = mapper.readTree(generalAQIMessageStream);

	    for (JsonNode generalMessageNode : generalMessageNodeRoot) {
		GeneralAQIMessage generalAQIMessage = msgParser.parseGeneralMessageNode(generalMessageNode);
		generalAQIMessages.add(generalAQIMessage);
	    }

	    /* Parse Specific Message Node */
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
