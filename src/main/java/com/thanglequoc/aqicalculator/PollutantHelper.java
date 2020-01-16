package com.thanglequoc.aqicalculator;

class PollutantHelper {
    
    static boolean isPollutantValidForNowCastAQICalculation(Pollutant pollutant) {
	return (Pollutant.O3.equals(pollutant) || Pollutant.PM10.equals(pollutant) 
		|| Pollutant.PM25.equals(pollutant));
    }
    
    private PollutantHelper() {
	
    }
}
