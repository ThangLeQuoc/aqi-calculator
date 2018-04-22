package com.thanglequoc.aqicalculator;

/**
 * Represent <i>upper bound index</i> (<b>I-high</b>) and <i>lower bound
 * index</i> (<b>I-low</b>) of a corresponding range in
 * <tt>PollutantBreakpoint</tt> of a pollutant
 * 
 * @author ThangLeQuoc
 */
class Index {

    /** The upper bound index. */
    private int min;

    /** The lower bound index. */
    private int max;

    Index(int min, int max) {
	this.min = min;
	this.max = max;
    }

    int getMinIndex() {
	return min;
    }

    void setMinIndex(int minIndex) {
	this.min = minIndex;
    }

    int getMaxIndex() {
	return max;
    }

    void setMaxIndex(int maxIndex) {
	this.max = maxIndex;
    }
}
