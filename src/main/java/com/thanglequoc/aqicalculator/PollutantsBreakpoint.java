package com.thanglequoc.aqicalculator;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class PollutantsBreakpoint.
 */
public class PollutantsBreakpoint {
	
	/** The breakpoint list. */
	ArrayList<PollutantBreakpoint> breakpointList;

	/**
	 * Instantiates a new pollutants breakpoint.
	 */
	public PollutantsBreakpoint() {
		breakpointList = new ArrayList<PollutantBreakpoint>();
	}

	/**
	 * Gets the breakpoint list.
	 *
	 * @return the breakpoint list
	 */
	public ArrayList<PollutantBreakpoint> getBreakpointList() {
		return breakpointList;
	}

	/**
	 * Sets the breakpoint list.
	 *
	 * @param breakpointList the new breakpoint list
	 */
	public void setBreakpointList(ArrayList<PollutantBreakpoint> breakpointList) {
		this.breakpointList = breakpointList;
	}

	/**
	 * Adds the pollutant breakpoint.
	 *
	 * @param pollutantBreakpoint the pollutant breakpoint
	 */
	public void addPollutantBreakpoint(PollutantBreakpoint pollutantBreakpoint) {
		this.breakpointList.add(pollutantBreakpoint);
	}

	/**
	 * Gets the pollutant breakpoint by code.
	 *
	 * @param pollutantCode the pollutant code
	 * @return the pollutant breakpoint by code
	 */
	public PollutantBreakpoint getPollutantBreakpointByCode(String pollutantCode) {
		for (PollutantBreakpoint pollutantBreakpoint : breakpointList) {
			if (pollutantBreakpoint.getCode().equals(pollutantCode)) {
				return pollutantBreakpoint;
			}
		}
		return null;
	}
}
