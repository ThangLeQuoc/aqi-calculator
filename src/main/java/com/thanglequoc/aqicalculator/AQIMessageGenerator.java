package com.thanglequoc.aqicalculator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class AQIMessageGenerator {
    
    private List<GeneralAQIInformation> generalAQIsInformation;
    private List<SpecificAQIInformation> specificAQIsInformation;
    private List<SensitiveGroups> sensitiveGroupsInformation;
    
    AQIMessageGenerator() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = AQIMessageGenerator.class.getClassLoader();
        generalAQIsInformation = new ArrayList<>();
        specificAQIsInformation = new ArrayList<>();
        AQIMessageParser msgParser = new AQIMessageParser();
        sensitiveGroupsInformation = new ArrayList<>();
        initializeMessageResources(mapper, classLoader, msgParser, null);
    }

    AQIMessageGenerator(AQICustomSettings userSettings) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = AQIMessageGenerator.class.getClassLoader();
        generalAQIsInformation = new ArrayList<>();
        specificAQIsInformation = new ArrayList<>();
        sensitiveGroupsInformation = new ArrayList<>();
        AQIMessageParser msgParser = new AQIMessageParser();

        initializeMessageResources(mapper, classLoader, msgParser, userSettings);
    }


    private void initializeMessageResources(ObjectMapper mapper, ClassLoader classLoader, AQIMessageParser msgParser, AQICustomSettings userSettings) throws IOException {

        String specificMessagePath = AQICalculatorConstants.AQI_SPECIFIC_MESSAGES_RESOURCE_PATH;
        String generalMessagePath = AQICalculatorConstants.AQI_GENERAL_MESSAGES_RESOURCE_PATH;
        String sensitiveGroupsPath = AQICalculatorConstants.AQI_SENSITIVE_GROUP_RESOURCE_PATH;

        if (userSettings != null && userSettings.isInOverrideSettingMode()) {
            specificMessagePath = userSettings.getSpecificMessageResourcePath();
            generalMessagePath = userSettings.getGeneralMessagesResourcePath();
            sensitiveGroupsPath = userSettings.getSensitiveGroupsResourcePath();
        }

        try (InputStream specificAQIMessagesStream = classLoader.getResourceAsStream(specificMessagePath);
             InputStream generalAQIMessageStream = classLoader.getResourceAsStream(generalMessagePath);
             InputStream sensitiveGroupsInfoStream = classLoader.getResourceAsStream(sensitiveGroupsPath)
             ) {

            /* Parse General Message Node */
            JsonNode generalMessageNodeRoot = mapper.readTree(generalAQIMessageStream);
            for (JsonNode generalMessageNode : generalMessageNodeRoot) {
                GeneralAQIInformation generalAQIInformation = msgParser.parseGeneralAQIInformationNode(generalMessageNode);
                this.generalAQIsInformation.add(generalAQIInformation);
            }
            /* Parse Specific Message Node */
            JsonNode specificMessageNodeRoot = mapper.readTree(specificAQIMessagesStream);
            for (JsonNode specificMessageNode : specificMessageNodeRoot) {
                SpecificAQIInformation specificAQIInformation = msgParser.parseSpecificAQIMessageNode(specificMessageNode);
                this.specificAQIsInformation.add(specificAQIInformation);
            }

            /* Parse Sensitive Group  */
            JsonNode sensitiveGroupNodeRoot = mapper.readTree(sensitiveGroupsInfoStream);
            for (JsonNode sensitiveGroupsNode: sensitiveGroupNodeRoot) {
                SensitiveGroups sensitiveGroups = msgParser.parseSensitiveGroupInformationNode(sensitiveGroupsNode);
                this.sensitiveGroupsInformation.add(sensitiveGroups);
            }
        }
    }
    
    GeneralAQIInformation getGeneralAQIMessageObjectOnAQILevel(int AQI) {
        for (GeneralAQIInformation generalAQIInformation : generalAQIsInformation) {
            if (generalAQIInformation.getIndex().getMinIndex() <= AQI && generalAQIInformation.getIndex().getMaxIndex() >= AQI)
                return generalAQIInformation;
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

    SensitiveGroups getSensitiveGroupsOfPollutant(Pollutant pollutant) {
        for (SensitiveGroups sensitiveGroups: sensitiveGroupsInformation) {
            if (sensitiveGroups.getPollutant().equals(pollutant)) {
                return sensitiveGroups;
            }
        }
        return null;
    }
    
}
