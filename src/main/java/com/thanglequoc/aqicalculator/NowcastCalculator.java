package com.thanglequoc.aqicalculator;

import com.thanglequoc.aqicalculator.Pollutant;

/**
 * A small size calculator use to calculate <b>Nowcast Concentration</b> from an
 * array set of concentration. The nowcast concentration will be send back to
 * <tt>AQICalculator</tt> object to calculate the AQI, which will then represent
 * Nowcast AQI
 * 
 * @author ThangLeQuoc
 */
class NowcastCalculator {

    double getNowcastConcentration(Pollutant pollutant, double[] data) {
	if (!PollutantHelper.isPollutantValidForNowcastAQICalculation(pollutant) || !isValidNowcastData(data))
	    return -1;
	return truncateConcentration(pollutant, data);

    }

    private double truncateConcentration(Pollutant pollutant, double[] data) {
	double weight = getWeightFactor(pollutant, data);
	double totalConcentrationWithWeight = 0;
	double totalWeight = 0;
	PollutantConcentrationTruncator truncator = new PollutantConcentrationTruncator();
	int indexDataSlot = getArraySizeToLoopForPollutant(pollutant);
	for (int i = 0; i < indexDataSlot; i++) {
	    if (data[i] < 0)
		continue;
	    else {
		totalConcentrationWithWeight += data[i] * Math.pow(weight, i);
		totalWeight += Math.pow(weight, i);
	    }
	}
	return truncator.getTruncatedPollutantConcentrationBaseOnPollutant(pollutant,
		totalConcentrationWithWeight / totalWeight);

    }

    private int getArraySizeToLoopForPollutant(Pollutant pollutant) {
	if (Pollutant.PM10.equals(pollutant) || Pollutant.PM25.equals(pollutant)) {
	    return 11;
	}
	return 7;
    }

    private boolean isValidNowcastData(double[] data) {
	int missingData = 0;
	for (int i = 0; i < 3; i++) {
	    if (data[i] < 0) {
		missingData++;
	    }
	}
	return (missingData >= 2) ? false : true;
    }

    private double getWeightFactor(Pollutant pollutant, double[] data) {
	double maxConcentration = Double.MIN_VALUE;
	double minConcentration = Double.MAX_VALUE;
	for (double i : data) {
	    if (i < 0)
		continue;
	    else {
		if (i > maxConcentration) {
		    maxConcentration = i;
		}
		if (i < minConcentration) {
		    minConcentration = i;
		}
	    }

	}

	if (Pollutant.O3.equals(pollutant)) {
	    /* No minimum weight factor for Ozone */
	    double range = maxConcentration - minConcentration;
	    double weightFactor = 1 - range / maxConcentration;
	    return weightFactor;
	} else {
	    /* For Particulate Matter, Minimum weight factor is 0.5 */
	    double range = maxConcentration - minConcentration;
	    double weightFactor = 1 - range / maxConcentration;
	    return (weightFactor > 0.5) ? weightFactor : 0.5;
	}
    }
}
