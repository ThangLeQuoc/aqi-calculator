package com.thanglequoc.aqicalculator;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class PollutantsBreakpointGenerator.
 */
public class PollutantsBreakpointGenerator {
	
	/** The pollutants breakpoint. */
	private PollutantsBreakpoint pollutantsBreakpoint;
	
	/** The pollutant breakpoint parser. */
	private PollutantBreakpointParser pollutantBreakpointParser;

	/**
	 * Instantiates a new pollutants breakpoint generator.
	 *
	 * @throws JsonProcessingException the json processing exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	 PollutantsBreakpointGenerator() throws JsonProcessingException, IOException{
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

	/**
	 * Gets the pollutants breakpoint.
	 *
	 * @return the pollutants breakpoint
	 */
	 PollutantsBreakpoint getPollutantsBreakpoint() {
		return pollutantsBreakpoint;
	}

	/**
	 * Sets the pollutants breakpoint.
	 *
	 * @param pollutantsBreakpoint the new pollutants breakpoint
	 */
	 void setPollutantsBreakpoint(PollutantsBreakpoint pollutantsBreakpoint) {
		this.pollutantsBreakpoint = pollutantsBreakpoint;
	}


}
