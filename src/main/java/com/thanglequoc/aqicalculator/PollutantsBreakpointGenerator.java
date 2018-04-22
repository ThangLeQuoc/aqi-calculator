package com.thanglequoc.aqicalculator;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

class PollutantsBreakpointGenerator {
    
    private static final String resourcePath = "AQIresource/aqi-breakpoint.json";
    
    private PollutantsBreakpoint pollutantsBreakpoint;
    private PollutantBreakpointParser pollutantBreakpointParser;

    PollutantsBreakpointGenerator() throws JsonProcessingException, IOException {
	pollutantBreakpointParser = new PollutantBreakpointParser();
	pollutantsBreakpoint = new PollutantsBreakpoint();
	parseBreakpoints();
    }

    private void parseBreakpoints() throws IOException, JsonProcessingException {
	ObjectMapper mapper = new ObjectMapper();
	ClassLoader classLoader = PollutantsBreakpointGenerator.class.getClassLoader();
	try (InputStream inputStream = classLoader.getResourceAsStream(resourcePath)) {
	    JsonNode root = mapper.readTree(inputStream);
	    for (JsonNode pollutantNode : root) {
		PollutantBreakpoint pollutantBreakpoint = pollutantBreakpointParser.parseNode(pollutantNode);
		pollutantsBreakpoint.addPollutantBreakpoint(pollutantBreakpoint);
	    }
	}
    }

    PollutantsBreakpoint getPollutantsBreakpoint() {
	return pollutantsBreakpoint;
    }
 
}
