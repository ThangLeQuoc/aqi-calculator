package com.thanglequoc.aqicalculator;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PollutantsBreakpointGenerator {
	private PollutantsBreakpoint pollutantsBreakpoint;
	private PollutantBreakpointParser pollutantBreakpointParser;
	private static String breakpointFilePath = "./src/main/resources/AQIresource/aqi-breakpoint.json";

	public PollutantsBreakpointGenerator() throws JsonProcessingException, IOException{
		pollutantBreakpointParser = new PollutantBreakpointParser();
		pollutantsBreakpoint = new PollutantsBreakpoint();

		ObjectMapper mapper = new ObjectMapper();

		ClassLoader classLoader = PollutantsBreakpointGenerator.class.getClassLoader();

		try (InputStream inputStream = classLoader.getResourceAsStream("AQIresource/aqi-breakpoint.json")) {
			JsonNode root = mapper.readTree(inputStream);

			for(JsonNode pollutantNode: root){
				PollutantBreakpoint pollutantBreakpoint = pollutantBreakpointParser.parseNode(pollutantNode);
				this.pollutantsBreakpoint.addPollutantBreakpoint(pollutantBreakpoint);
			}
		}
		
		
	}

	public PollutantsBreakpoint getPollutantsBreakpoint() {
		return pollutantsBreakpoint;
	}

	public void setPollutantsBreakpoint(PollutantsBreakpoint pollutantsBreakpoint) {
		this.pollutantsBreakpoint = pollutantsBreakpoint;
	}


}
