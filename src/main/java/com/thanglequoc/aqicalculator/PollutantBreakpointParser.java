package com.thanglequoc.aqicalculator;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

class PollutantBreakpointParser {

    PollutantBreakpoint parseNode(JsonNode node) {
	
	String code = node.path(AQIResourcePathConstants.CODE).asText();
	String unit = node.path(AQIResourcePathConstants.UNIT).asText();
	String period = node.path(AQIResourcePathConstants.PERIOD).asText();
	PollutantBreakpoint pollutantBreakpoint = new PollutantBreakpoint(code, unit, period);

	List<PollutantConcentration> concentrationList = new ArrayList<>();

	JsonNode concentrationArray = node.path(AQIResourcePathConstants.CONCENTRATIONS);
	for (JsonNode concentrationNode : concentrationArray) {
	    double minConcentration = concentrationNode.path(AQIResourcePathConstants.MIN).asDouble();
	    double maxConcentration = concentrationNode.path(AQIResourcePathConstants.MAX).asDouble();

	    JsonNode indexObj = concentrationNode.path(AQIResourcePathConstants.INDEX);
	    int minIndex = indexObj.path(AQIResourcePathConstants.MIN).asInt();
	    int maxIndex = indexObj.path(AQIResourcePathConstants.MAX).asInt();
	    Index index = new Index(minIndex, maxIndex);

	    PollutantConcentration concentration = new PollutantConcentration(index, minConcentration,
		    maxConcentration);
	    concentrationList.add(concentration);
	}

	pollutantBreakpoint.setPollutantConcentrations(concentrationList);

	return pollutantBreakpoint;
    }

}
