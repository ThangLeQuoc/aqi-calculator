package com.thanglequoc.aqicalculator;


// TODO: Auto-generated Javadoc
/**
 * Represent <i>upper bound index</i> (<b>I-high</b>) and <i>lower bound index</i> (<b>I-low</b>) of a corresponding range in <tt>PollutantBreakpoint</tt> of a pollutant 
 * 
 * @author ThangLeQuoc
 */
public class PollutantIndex {
	
	/** The upper bound index. */
	private int minIndex;

	
	/** The lower bound index. */
	private int maxIndex;
	
	/**
	 * Gets the lower bound index.
	 *
	 * @return the lower bound index
	 */
	int getMinIndex() {
		return minIndex;
	}
	
	/**
	 * Sets the lower bound index.
	 *
	 * @param minIndex the new lower bound index
	 */
	void setMinIndex(int minIndex) {
		this.minIndex = minIndex;
	}
	
	/**
	 * Gets the upper bound index.
	 *
	 * @return the upper bound index
	 */
	int getMaxIndex() {
		return maxIndex;
	}
	
	/**
	 * Sets the upper bound index.
	 *
	 * @param maxIndex the new upper bound index
	 */
	void setMaxIndex(int maxIndex) {
		this.maxIndex = maxIndex;
	}
}
