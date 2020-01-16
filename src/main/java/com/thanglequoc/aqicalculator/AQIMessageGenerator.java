package com.thanglequoc.aqicalculator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class AQIMessageGenerator {
    
    private List<GenericAQIInformation> genericAQIsInformation;
    private List<SpecificAQIInformation> specificAQIsInformation;
    
    AQIMessageGenerator() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = AQIMessageGenerator.class.getClassLoader();
        genericAQIsInformation = new ArrayList<>();
        specificAQIsInformation = new ArrayList<>();
        AQIMessageParser msgParser = new AQIMessageParser();
        
        initializeMessageResources(mapper, classLoader, msgParser, null);
    }

    AQIMessageGenerator(AQICustomSettings userSettings) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = AQIMessageGenerator.class.getClassLoader();
        genericAQIsInformation = new ArrayList<>();
        specificAQIsInformation = new ArrayList<>();
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
                GenericAQIInformation genericAQIInformation = msgParser.parseGenericAQIInformationNode(generalMessageNode);
                this.genericAQIsInformation.add(genericAQIInformation);
            }
            /* Parse Specific Message Node */
            JsonNode specificMessageNodeRoot = mapper.readTree(specificAQIMessagesStream);
            for (JsonNode specificMessageNode : specificMessageNodeRoot) {
                SpecificAQIInformation specificAQIInformation = msgParser.parseSpecificAQIMessageNode(specificMessageNode);
                this.specificAQIsInformation.add(specificAQIInformation);
            }
        }
    }
    
    GenericAQIInformation getGeneralAQIMessageObjectOnAQILevel(int AQI) {
        for (GenericAQIInformation genericAQIInformation : genericAQIsInformation) {
            if (genericAQIInformation.getIndex().getMinIndex() <= AQI && genericAQIInformation.getIndex().getMaxIndex() >= AQI)
                return genericAQIInformation;
        }
        return null;
    }
    
    SpecificAQILevelMessage getSpecificAQILevelMessageOnAQILevelOfPollutant(Pollutant pollutant, int AQI) {
        for (SpecificAQIInformation specificAQIInformation : specificAQIsInformation) {
            if (specificAQIInformation.getPollutant().equals(pollutant)) {
                
                for (SpecificAQILevelMessage specificAQILevelMessage : specificAQIInformation.getLevelMessages()) {
                    if (specificAQILevelMessage.getIndex().getMinIndex() <= AQI
                            && specificAQILevelMessage.getIndex().getMaxIndex() >= AQI)
                        return specificAQILevelMessage;
                }
            }
        }
        
        return null;
    }
    
}
