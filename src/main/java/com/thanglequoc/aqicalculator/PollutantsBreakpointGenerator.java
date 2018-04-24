package com.thanglequoc.aqicalculator;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

class PollutantsBreakpointGenerator {

    private PollutantsBreakpoint pollutantsBreakpoint;
    private PollutantBreakpointParser pollutantBreakpointParser;

    PollutantsBreakpointGenerator() throws IOException {
	pollutantBreakpointParser = new PollutantBreakpointParser();
	pollutantsBreakpoint = new PollutantsBreakpoint();
	parseBreakpoints();
    }

    private void parseBreakpoints() throws IOException {
	ObjectMapper mapper = new ObjectMapper();
	ClassLoader classLoader = PollutantsBreakpointGenerator.class.getClassLoader();
	try (InputStream inputStream = classLoader
		.getResourceAsStream(AQICalculatorConstants.AQI_BREAKPOINT_RESOURCE_PATH)) {
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
