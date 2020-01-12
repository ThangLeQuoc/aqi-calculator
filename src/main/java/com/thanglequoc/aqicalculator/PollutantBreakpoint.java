package com.thanglequoc.aqicalculator;

import java.util.List;
import java.util.Optional;

class PollutantBreakpoint {
    
    private Pollutant pollutant;
    private String unit;
    private String period;
    
    private List<PollutantConcentration> concentrations;
    
    PollutantBreakpoint(Pollutant code, String unit, String period) {
        this.pollutant = code;
        this.unit = unit;
        this.period = period;
    }
    
    Pollutant getPollutant() {
        return pollutant;
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
     * @param concentration the concentration
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
