package com.thanglequoc.aqicalculator;

class PollutantHelper {
    
    static boolean isPollutantValidForNowcastAQICalculation(Pollutant pollutant) {
	return (Pollutant.O3.equals(pollutant) || Pollutant.PM10.equals(pollutant) 
		|| Pollutant.PM25.equals(pollutant)) ? true:false;
    }
    
    private PollutantHelper() {
	
    }
}
