package com.thanglequoc.aqicalculator;

// TODO: Auto-generated Javadoc
/**
 * Represent <i>upper bound index</i> (<b>I-high</b>) and <i>lower bound
 * index</i> (<b>I-low</b>) of a corresponding range in
 * <tt>PollutantBreakpoint</tt> of a pollutant
 * 
 * @author ThangLeQuoc
 */
public class Index {

    /** The upper bound index. */
    private int min;

    /** The lower bound index. */
    private int max;

    /**
     * @param min
     * @param max
     */
    public Index(int min, int max) {
	this.min = min;
	this.max = max;
    }

    /**
     * Default index constructor
     */
    public Index() {
    }

    /**
     * Gets the lower bound index.
     *
     * @return the lower bound index
     */
    int getMinIndex() {
	return min;
    }

    /**
     * Sets the lower bound index.
     *
     * @param minIndex
     *            the new lower bound index
     */
    void setMinIndex(int minIndex) {
	this.min = minIndex;
    }

    /**
     * Gets the upper bound index.
     *
     * @return the upper bound index
     */
    int getMaxIndex() {
	return max;
    }

    /**
     * Sets the upper bound index.
     *
     * @param maxIndex
     *            the new upper bound index
     */
    void setMaxIndex(int maxIndex) {
	this.max = maxIndex;
    }
}
