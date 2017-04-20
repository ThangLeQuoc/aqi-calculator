package com.thanglequoc.aqicalculator;

public class PollutantConcentration {
	private double minConcentration;
	private double maxConcentration;
	private PollutantIndex index;
	
	
	
	public double getMinConcentration() {
		return minConcentration;
	}
	public void setMinConcentration(double minConcentration) {
		this.minConcentration = minConcentration;
	}
	public double getMaxConcentration() {
		return maxConcentration;
	}
	public void setMaxConcentration(double maxConcentration) {
		this.maxConcentration = maxConcentration;
	}
	public PollutantIndex getIndex() {
		return index;
	}
	public void setIndex(PollutantIndex index) {
		this.index = index;
	}
}
