package com.thanglequoc.aqicalculator;

import java.util.ArrayList;
import java.util.List;

public class SpecificAQIMessage {
    private String pollutantCode;
    private List<SpecificAQILevelMessage> levelMessages;
    
    /**
     * @param pollutantCode
     * @param levelMessages
     */
    SpecificAQIMessage(String pollutantCode, List<SpecificAQILevelMessage> levelMessages) {
	super();
	this.pollutantCode = pollutantCode;
	this.levelMessages = levelMessages;
    }

    /**
     * @return the pollutantCode
     */
    String getPollutantCode() {
        return pollutantCode;
    }

    /**
     * @return the levelMessages
     */
    List<SpecificAQILevelMessage> getLevelMessages() {
        return levelMessages;
    }

    /**
     * @param pollutantCode the pollutantCode to set
     */
    void setPollutantCode(String pollutantCode) {
        this.pollutantCode = pollutantCode;
    }

    /**
     * @param levelMessages the levelMessages to set
     */
    void setLevelMessages(ArrayList<SpecificAQILevelMessage> levelMessages) {
        this.levelMessages = levelMessages;
    }

}
