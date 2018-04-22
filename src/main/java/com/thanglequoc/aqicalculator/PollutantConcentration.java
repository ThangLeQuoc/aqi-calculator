package com.thanglequoc.aqicalculator;

public class PollutantConcentration {
    
    private double min;

    private double max;

    private Index index;

    double getMinConcentration() {
	return min;
    }

    void setMinConcentration(double minConcentration) {
	this.min = minConcentration;
    }

    double getMaxConcentration() {
	return max;
    }

    void setMaxConcentration(double maxConcentration) {
	this.max = maxConcentration;
    }

    Index getIndex() {
	return index;
    }

    void setIndex(Index index) {
	this.index = index;
    }
    
}
