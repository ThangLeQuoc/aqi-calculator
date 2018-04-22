package com.thanglequoc.aqicalculator;

/**
 * Represent <i>upper bound index</i> (<b>I-high</b>) and <i>lower bound
 * index</i> (<b>I-low</b>) of a corresponding range in
 * <tt>PollutantBreakpoint</tt> of a pollutant
 * 
 * @author ThangLeQuoc
 */
class Index {

    private int min;
    private int max;

    Index(int min, int max) {
	this.min = min;
	this.max = max;
    }

    int getMinIndex() {
	return min;
    }

    int getMaxIndex() {
	return max;
    }

}
