package com.thanglequoc.aqicalculator;

import java.util.List;

/**
 * Object that hold a list of <b>SpecificAQILevelMessage</b> for a pollutant
 * 
 * @author ThangLeQuoc
 */
class SpecificAQIMessage {

    private String pollutantCode;
    private List<SpecificAQILevelMessage> levelMessages;

    SpecificAQIMessage(String pollutantCode, List<SpecificAQILevelMessage> levelMessages) {
	this.pollutantCode = pollutantCode;
	this.levelMessages = levelMessages;
    }

    String getPollutantCode() {
	return pollutantCode;
    }

    List<SpecificAQILevelMessage> getLevelMessages() {
	return levelMessages;
    }

}
