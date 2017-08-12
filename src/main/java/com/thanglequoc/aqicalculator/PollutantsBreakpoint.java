package com.thanglequoc.aqicalculator;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * PollutantsBreakpoint, which represent the whole AQI breakpoint table
 * <p>
 * It contain a list of smaller <tt>PollutantBreakpoint</tt>, each <tt>PollutantBreakpoint</tt> in this list represent <b>breakpoint</b> of a pollutant code
 * @author ThangLeQuoc
 */
public class PollutantsBreakpoint {
	
	/** The breakpoint list, represent the AQI breakpoint table */
	ArrayList<PollutantBreakpoint> breakpointList;

	/**
	 * Instantiates a new pollutants breakpoint .
	 */
	public PollutantsBreakpoint() {
		breakpointList = new ArrayList<PollutantBreakpoint>();
	}

	/**
	 * Gets the breakpoint list.
	 *
	 * @return the breakpoint list
	 */
	ArrayList<PollutantBreakpoint> getBreakpointList() {
		return breakpointList;
	}

	/**
	 * Sets the breakpoint list.
	 *
	 * @param breakpointList the new breakpoint list
	 */
	void setBreakpointList(ArrayList<PollutantBreakpoint> breakpointList) {
		this.breakpointList = breakpointList;
	}

	/**
	 * Adds the pollutant breakpoint to the table list.
	 *
	 * @param pollutantBreakpoint the pollutant breakpoint
	 */
	void addPollutantBreakpoint(PollutantBreakpoint pollutantBreakpoint) {
		this.breakpointList.add(pollutantBreakpoint);
	}

	/**
	 * Gets the pollutant breakpoint by pollutant code.
	 *
	 * @param pollutantCode the pollutant code (ex <i>PM10, PM2.5, O3, SO2, NO2, CO</i>)
	 * @return the pollutant breakpoint by code
	 */
	PollutantBreakpoint getPollutantBreakpointByCode(String pollutantCode) {
		for (PollutantBreakpoint pollutantBreakpoint : breakpointList) {
			if (pollutantBreakpoint.getCode().equals(pollutantCode)) {
				return pollutantBreakpoint;
			}
		}
		return null;
	}
}
