package com.thanglequoc.aqicalculator;

import java.util.List;

/**
 * Object that hold a list of <b>SpecificAQILevelMessage</b> for a pollutant
 * @author ThangLeQuoc
 * */
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



}
