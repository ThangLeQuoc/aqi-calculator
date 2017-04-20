package com.thanglequoc.aqicalculator;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;

public class PollutantBreakpointParser {
	private PollutantBreakpoint pollutantBreakpoint;

	public PollutantBreakpointParser() {
		
	}

	public PollutantBreakpoint parseNode(JsonNode node) {
		this.pollutantBreakpoint = new PollutantBreakpoint();
		/**
		 * code: Pollutant Code (ex: PM10, PM2.5) unit: Unit of Measurement (ex:
		 * ug/m3) period: Breakpoint Period (ex: 24h)
		 **/
		String code = node.path("code").asText();
		String unit = node.path("unit").asText();
		String period = node.path("period").asText();

		pollutantBreakpoint.setCode(code);
		pollutantBreakpoint.setUnit(unit);
		pollutantBreakpoint.setPeriod(period);

		ArrayList<PollutantConcentration> concentrationList = new ArrayList<PollutantConcentration>();
		
		/** Parse Concentration array **/
		JsonNode concentrationArray = node.path("concentrations");
		for (JsonNode concentrationNode : concentrationArray) {
			PollutantConcentration concentration = new PollutantConcentration();
			concentration.setMinConcentration(concentrationNode.path("min").asDouble());
			concentration.setMaxConcentration(concentrationNode.path("max").asDouble());
			
			/** Parse Pollutant Index Object for that concentration **/
			
			// get value from Json node
			JsonNode indexObj = concentrationNode.path("index");
			int minIndex = indexObj.path("min").asInt();
			int maxIndex = indexObj.path("max").asInt();
			
			PollutantIndex index = new PollutantIndex();
			index.setMinIndex(minIndex);
			index.setMaxIndex(maxIndex);
			/**---- **/
			
			concentration.setIndex(index);
			
			/* Add this concentration to concentrationList */
			concentrationList.add(concentration);
		}
		
		pollutantBreakpoint.setPollutantConcentrationList(concentrationList);
		
		return this.pollutantBreakpoint;
	}

}
