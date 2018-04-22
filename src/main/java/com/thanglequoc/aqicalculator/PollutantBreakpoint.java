package com.thanglequoc.aqicalculator;

import java.util.List;
import java.util.Optional;

class PollutantBreakpoint {

    private String code;
    private String unit;
    private String period;

    private List<PollutantConcentration> concentrations;

    PollutantBreakpoint(String code, String unit, String period) {
	this.code = code;
	this.unit = unit;
	this.period = period;
    }

    String getCode() {
	return code;
    }

    String getUnit() {
	return unit;
    }

    String getPeriod() {
	return period;
    }

    List<PollutantConcentration> getPollutantConcentrations() {
	return concentrations;
    }

    void setPollutantConcentrations(List<PollutantConcentration> pollutantConcentrations) {
	this.concentrations = pollutantConcentrations;
    }

    /**
     * Gets the concentration range with avg concentration.
     *
     * @param concentration
     *            the concentration
     * @return the concentration range with avg concentration
     */
    Optional<PollutantConcentration> getConcentrationRangeWithAvgConcentration(double concentration) {
	for (PollutantConcentration pollutantConcentration : concentrations) {
	    if (concentration >= pollutantConcentration.getMinConcentration()
		    && concentration <= pollutantConcentration.getMaxConcentration()) {
		return Optional.of(pollutantConcentration);
	    }
	}
	return Optional.empty();
    }
}
