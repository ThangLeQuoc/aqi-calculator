package com.thanglequoc.aqicalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * PollutantsBreakpoint, which represent the whole AQI breakpoint table
 * <p>
 * It contain a list of smaller <tt>PollutantBreakpoint</tt>, each
 * <tt>PollutantBreakpoint</tt> in this list represent <b>breakpoint</b> of a
 * pollutant code
 * 
 * @author ThangLeQuoc
 */
public class PollutantsBreakpoint {

    List<PollutantBreakpoint> breakpoints;

    /**
     * Instantiates a new pollutants breakpoint .
     */
    PollutantsBreakpoint() {
	breakpoints = new ArrayList<>();
    }

    List<PollutantBreakpoint> getBreakpointList() {
	return breakpoints;
    }

    void setBreakpointList(ArrayList<PollutantBreakpoint> breakpointList) {
	this.breakpoints = breakpointList;
    }

    /**
     * Adds the pollutant breakpoint to the table list.
     *
     * @param pollutantBreakpoint
     *            the pollutant breakpoint
     */
    void addPollutantBreakpoint(PollutantBreakpoint pollutantBreakpoint) {
	this.breakpoints.add(pollutantBreakpoint);
    }

    /**
     * Gets the pollutant breakpoint by pollutant code.
     *
     * @param pollutantCode the pollutant code (ex <i>PM10, PM2.5, O3, SO2, NO2, CO</i>)
     * @return the pollutant breakpoint by code
     */
    PollutantBreakpoint getPollutantBreakpointByCode(String pollutantCode) {
	for (PollutantBreakpoint pollutantBreakpoint : breakpoints) {
	    if (pollutantBreakpoint.getCode().equals(pollutantCode)) {
		return pollutantBreakpoint;
	    }
	}
	return null;
    }
}
