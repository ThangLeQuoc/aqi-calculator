package com.thanglequoc.aqicalculator;

/**
 * The Class PollutantConcentration.
 */
public class PollutantConcentration {
	
	/** The min concentration. */
	private double min;
	
	/** The max concentration. */
	private double max;
	
	/** The index. */
	private Index index;
	
	
	
	/**
	 * Gets the min concentration.
	 *
	 * @return the min concentration
	 */
	public double getMinConcentration() {
		return min;
	}
	
	/**
	 * Sets the min concentration.
	 *
	 * @param minConcentration the new min concentration
	 */
	public void setMinConcentration(double minConcentration) {
		this.min = minConcentration;
	}
	
	/**
	 * Gets the max concentration.
	 *
	 * @return the max concentration
	 */
	public double getMaxConcentration() {
		return max;
	}
	
	/**
	 * Sets the max concentration.
	 *
	 * @param maxConcentration the new max concentration
	 */
	public void setMaxConcentration(double maxConcentration) {
		this.max = maxConcentration;
	}
	
	/**
	 * Gets the index.
	 *
	 * @return the index
	 */
	public Index getIndex() {
		return index;
	}
	
	/**
	 * Sets the index.
	 *
	 * @param index the new index
	 */
	public void setIndex(Index index) {
		this.index = index;
	}
}
