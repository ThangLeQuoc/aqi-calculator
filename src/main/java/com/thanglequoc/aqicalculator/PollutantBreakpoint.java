package com.thanglequoc.aqicalculator;

import java.util.ArrayList;

public class PollutantBreakpoint {
	private String code;
	private String unit;
	private String period;
	private ArrayList<PollutantConcentration> pollutantConcentrationList;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public ArrayList<PollutantConcentration> getPollutantConcentrationList() {
		return pollutantConcentrationList;
	}

	public void setPollutantConcentrationList(ArrayList<PollutantConcentration> pollutantConcentrationList) {
		this.pollutantConcentrationList = pollutantConcentrationList;
	}
	
	
	//Get Low level concentration and High level concentration with avg input concentration.
	public PollutantConcentration getConcentrationRangeWithAvgConcentration(double concentration){
		for(PollutantConcentration pollutantConcentration: pollutantConcentrationList){
			if(concentration >= pollutantConcentration.getMinConcentration() && concentration <= pollutantConcentration.getMaxConcentration()){
				return pollutantConcentration;
			}
		}
		return null;
	}
}
