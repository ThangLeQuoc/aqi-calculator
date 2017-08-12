package com.thanglequoc.aqicalculator;

import com.thanglequoc.aqicalculator.PollutantCode;

/**
*  A small size calculator use to calculate <b>Nowcast Concentration</b> from an array set of concentration. The nowcast concentration will be send back to <tt>AQICalculator</tt> object to calculate the AQI, which will then represent
*  Nowcast AQI 
*  
 * @author ThangLeQuoc
 */
public class NowcastCalculator {
	
	/** The truncator. */
	private PollutantConcentrationTruncator truncator;
	
	/** The pm10. */
	private static String PM10 = PollutantCode.PM10.getLiteral();
	
	/** The pm25. */
	private static String PM25 = PollutantCode.PM25.getLiteral();
	
	/** The o3. */
	private static String O3 = PollutantCode.O3.getLiteral();

	
	/**
	 * Instantiates a new nowcast calculator.
	 */
	public NowcastCalculator() {
		this.truncator = new PollutantConcentrationTruncator();
	}

	/**
	 * Gets the nowcast concentration.
	 *
	 * @param pollutantCode the pollutant code
	 * @param data the data
	 * @return the nowcast concentration
	 */
	public double getNowcastConcentration(String pollutantCode, double[] data) {
		if (!isValidNowcastData(data))
			return -1;
		else {
			double totalConcentrationWithWeight = 0;
			double weight = getWeightFactor(pollutantCode, data);
			double totalWeight = 0;

			if (pollutantCode.equals(PM10) || pollutantCode.equals(PM25)) {
				for (int i = 0; i < 11; i++) {
					if (data[i] < 0)
						continue;
					else {
						totalConcentrationWithWeight += data[i] * Math.pow(weight, i);
						totalWeight += Math.pow(weight, i);
					}

				}
				
				return truncator.getTruncatedPollutantConcentrationOnPollutantCode(pollutantCode, totalConcentrationWithWeight/totalWeight);

			} else if (pollutantCode.equals(O3)) {
				for (int i = 0; i < 7; i++) {
					if (data[i] < 0)
						continue;
					else {
						totalConcentrationWithWeight += data[i] * Math.pow(weight, i);
						totalWeight += Math.pow(weight, i);
					}
				}
				return truncator.getTruncatedPollutantConcentrationOnPollutantCode(pollutantCode, totalConcentrationWithWeight/totalWeight);
			}
		}
		return 0;
	}

	/**
	 * Checks if is valid nowcast data.
	 *
	 * @param data the data
	 * @return true, if is valid nowcast data
	 */
	private boolean isValidNowcastData(double[] data) {
		int missingData = 0;
		for (int i = 0; i < 3; i++) {
			if (data[i] < 0) {
				missingData++;
			}
		}
		if (missingData >= 2)
			return false;
		return true;
	}

	/**
	 * Gets the weight factor.
	 *
	 * @param pollutantCode the pollutant code
	 * @param data the data
	 * @return the weight factor
	 */
	private double getWeightFactor(String pollutantCode, double[] data) {
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

		if (pollutantCode.equals(O3)) {
			/* No minimum weight factor */
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
