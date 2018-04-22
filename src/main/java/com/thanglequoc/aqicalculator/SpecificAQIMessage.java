package com.thanglequoc.aqicalculator;

import java.util.List;

/**
 * Object that hold a list of <b>SpecificAQILevelMessage</b> for a pollutant
 * 
 * @author ThangLeQuoc
 */
class SpecificAQIMessage {

    private Pollutant pollutant;
    private List<SpecificAQILevelMessage> levelMessages;

    SpecificAQIMessage(Pollutant pollutant, List<SpecificAQILevelMessage> levelMessages) {
	this.pollutant = pollutant;
	this.levelMessages = levelMessages;
    }

    Pollutant getPollutant() {
	return pollutant;
    }

    List<SpecificAQILevelMessage> getLevelMessages() {
	return levelMessages;
    }

}
