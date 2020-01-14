package com.thanglequoc.aqicalculator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class AQIMessageGenerator {
    
    private List<GeneralAQIMessage> generalAQIMessages;
    private List<SpecificAQIMessage> specificAQIMessages;
    
    AQIMessageGenerator() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = AQIMessageGenerator.class.getClassLoader();
        generalAQIMessages = new ArrayList<>();
        specificAQIMessages = new ArrayList<>();
        AQIMessageParser msgParser = new AQIMessageParser();
        
        initializeMessageResources(mapper, classLoader, msgParser, null);
    }

    AQIMessageGenerator(AQICustomSettings userSettings) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = AQIMessageGenerator.class.getClassLoader();
        generalAQIMessages = new ArrayList<>();
        specificAQIMessages = new ArrayList<>();
        AQIMessageParser msgParser = new AQIMessageParser();

        initializeMessageResources(mapper, classLoader, msgParser, userSettings);
    }

    private void initializeMessageResources(ObjectMapper mapper, ClassLoader classLoader, AQIMessageParser msgParser, AQICustomSettings userSettings) throws IOException {

        String specificMessagePath = AQICalculatorConstants.AQI_SPECIFIC_MESSAGES_RESOURCE_PATH;
        String generalMessagePath = AQICalculatorConstants.AQI_GENERAL_MESSAGES_RESOURCE_PATH;
        if (userSettings != null && userSettings.isInOverrideSettingMode()) {
            specificMessagePath = userSettings.getSpecificMessageResourcePath();
            generalMessagePath = userSettings.getGeneralMessagesResourcePath();
        }

        try (InputStream specificAQIMessagesStream = classLoader
                .getResourceAsStream(specificMessagePath);
             InputStream generalAQIMessageStream = classLoader
                     .getResourceAsStream(generalMessagePath)) {

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
    
    SpecificAQILevelMessage getSpecificAQILevelMessageOnAQILevelOfPollutant(Pollutant pollutant, int AQI) {
        for (SpecificAQIMessage specificAQIMessage : specificAQIMessages) {
            if (specificAQIMessage.getPollutant().equals(pollutant)) {
                
                for (SpecificAQILevelMessage specificAQILevelMessage : specificAQIMessage.getLevelMessages()) {
                    if (specificAQILevelMessage.getIndex().getMinIndex() <= AQI
                            && specificAQILevelMessage.getIndex().getMaxIndex() >= AQI)
                        return specificAQILevelMessage;
                }
            }
        }
        
        return null;
    }
    
}
