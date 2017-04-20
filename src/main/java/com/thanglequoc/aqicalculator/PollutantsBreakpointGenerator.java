package com.thanglequoc.aqicalculator;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PollutantsBreakpointGenerator {
	private PollutantsBreakpoint pollutantsBreakpoint;
	private PollutantBreakpointParser pollutantBreakpointParser;
	private static String breakpointFilePath = "./src/main/resources/AQIresource/aqi-breakpoint.json";
	
	private File breakpointFile;
	
	public PollutantsBreakpointGenerator() throws JsonProcessingException, IOException{
		pollutantBreakpointParser = new PollutantBreakpointParser();
		pollutantsBreakpoint = new PollutantsBreakpoint();
		File breakpointFile = new File(breakpointFilePath);
		setBreakpointFile(breakpointFile);
		
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode root = mapper.readTree(breakpointFile);
		
		for(JsonNode pollutantNode: root){
			PollutantBreakpoint pollutantBreakpoint = pollutantBreakpointParser.parseNode(pollutantNode);
			this.pollutantsBreakpoint.addPollutantBreakpoint(pollutantBreakpoint);
		}
		
		
	}

	public PollutantsBreakpoint getPollutantsBreakpoint() {
		return pollutantsBreakpoint;
	}

	public void setPollutantsBreakpoint(PollutantsBreakpoint pollutantsBreakpoint) {
		this.pollutantsBreakpoint = pollutantsBreakpoint;
	}

	public File getBreakpointFile() {
		return breakpointFile;
	}

	public void setBreakpointFile(File breakpointFile) {
		this.breakpointFile = breakpointFile;
	}
	
	
}
