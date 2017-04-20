package com.thanglequoc.aqicalculator;

import com.thanglequoc.aqicalculator.PollutantCode;

public class PollutantConcentrationTruncator {
	/***
	 * Define Truncation Rule for Pollutant and apply truncation
	 */
	private static String PM10 = PollutantCode.PM10.getLiteral();
	private static String PM25 = PollutantCode.PM25.getLiteral();
	private static String O3 = PollutantCode.O3.getLiteral();
	private static String CO = PollutantCode.CO.getLiteral();
	private static String SO2 = PollutantCode.SO2.getLiteral();
	private static String NO2 = PollutantCode.NO2.getLiteral();

	public double getTruncatedPollutantConcentrationOnPollutantCode(String pollutantCode, double concentration) {
		// Truncate to integer for PM10, SO2, NO2
		if (pollutantCode.equals(PM10) || pollutantCode.equals(SO2) || pollutantCode.equals(NO2)) {
			return Math.round(concentration);
		}
		// Truncate to 1 decimal place for PM2.5 and CO
		else if (pollutantCode.equals(CO) || pollutantCode.equals(PM25)) {
			return Math.round(concentration * 10d) / 10d;
		}
		// For Ozone, truncate to 3 decimal place
		else {
			return Math.round(concentration * 1000d) / 1000d;
		}
	}

}
