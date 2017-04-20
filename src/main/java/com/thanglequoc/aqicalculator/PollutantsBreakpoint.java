package com.thanglequoc.aqicalculator;

import java.util.ArrayList;

public class PollutantsBreakpoint {
	ArrayList<PollutantBreakpoint> breakpointList;

	public PollutantsBreakpoint() {
		breakpointList = new ArrayList<PollutantBreakpoint>();
	}

	public ArrayList<PollutantBreakpoint> getBreakpointList() {
		return breakpointList;
	}

	public void setBreakpointList(ArrayList<PollutantBreakpoint> breakpointList) {
		this.breakpointList = breakpointList;
	}

	public void addPollutantBreakpoint(PollutantBreakpoint pollutantBreakpoint) {
		this.breakpointList.add(pollutantBreakpoint);
	}

	public PollutantBreakpoint getPollutantBreakpointByCode(String pollutantCode) {
		for (PollutantBreakpoint pollutantBreakpoint : breakpointList) {
			if (pollutantBreakpoint.getCode().equals(pollutantCode)) {
				return pollutantBreakpoint;
			}
		}
		return null;
	}
}
