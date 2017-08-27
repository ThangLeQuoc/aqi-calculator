package com.thanglequoc.aqicalculator;

import java.util.ArrayList;
import java.util.Optional;

/**
 * PollutantBreakpoint.
 */
public class PollutantBreakpoint {
	
	/** The code. */
	private String code;
	
	/** The unit. */
	private String unit;
	
	/** The period. */
	private String period;
	
	/** The pollutant concentration list. */
	private ArrayList<PollutantConcentration> concentrations;

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the unit.
	 *
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * Sets the unit.
	 *
	 * @param unit the new unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * Gets the period.
	 *
	 * @return the period
	 */
	public String getPeriod() {
		return period;
	}

	/**
	 * Sets the period.
	 *
	 * @param period the new period
	 */
	public void setPeriod(String period) {
		this.period = period;
	}

	/**
	 * Gets the pollutant concentration list.
	 *
	 * @return the pollutant concentration list
	 */
	public ArrayList<PollutantConcentration> getPollutantConcentrationList() {
		return concentrations;
	}

	/**
	 * Sets the pollutant concentration list.
	 *
	 * @param pollutantConcentrationList the new pollutant concentration list
	 */
	public void setPollutantConcentrationList(ArrayList<PollutantConcentration> pollutantConcentrationList) {
		this.concentrations = pollutantConcentrationList;
	}
	
	
	/**
	 * Gets the concentration range with avg concentration.
	 *
	 * @param concentration the concentration
	 * @return the concentration range with avg concentration
	 */
	//Get Low level concentration and High level concentration with avg input concentration.
	public Optional<PollutantConcentration> getConcentrationRangeWithAvgConcentration(double concentration){
		for(PollutantConcentration pollutantConcentration: concentrations){
			if(concentration >= pollutantConcentration.getMinConcentration() && concentration <= pollutantConcentration.getMaxConcentration()){
				return Optional.of(pollutantConcentration); 
			}
		}
		return Optional.empty();
	}
}
