package com.thanglequoc.aqicalculator;

public class PollutantConcentration {

    private double min;
    private double max;
    private Index index;

    PollutantConcentration(Index index, double min, double max) {
	this.index = index;
	this.min = min;
	this.max = max;
    }

    double getMinConcentration() {
	return min;
    }

    double getMaxConcentration() {
	return max;
    }

    Index getIndex() {
	return index;
    }
}
