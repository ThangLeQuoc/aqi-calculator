package com.thanglequoc.aqicalculator;

import com.thanglequoc.aqicalculator.PollutantCode;


/**
 * PollutantConcentrationTruncator which will support the truncation for pollutant based on <b>US EPA</b> rule
 * <p>
 * @see <a href="https://github.com/ThangLeQuoc/aqi-calculator"> AQI Calculator Guide</a> , section <b>AQI Calculation Turtorial </b>
 * 
 * @author ThangLeQuoc
 */
public class PollutantConcentrationTruncator {
	
	/** String represent PM10 pollutant code */
	private static String PM10 = PollutantCode.PM10.getLiteral();
	
	/** String represent PM2.5 pollutant code */
	private static String PM25 = PollutantCode.PM25.getLiteral();
	
	/** String represent O3 pollutant code */
	private static String O3 = PollutantCode.O3.getLiteral();
	
	/** String represent CO pollutant code */
	private static String CO = PollutantCode.CO.getLiteral();
	
	/** String represent SO2 pollutant code */
	private static String SO2 = PollutantCode.SO2.getLiteral();
	
	/** String represent NO2 pollutant code */
	private static String NO2 = PollutantCode.NO2.getLiteral();

	
	/**
	 * Gets the truncated pollutant concentration on pollutant code.
	 * <p>
	 * For <i>PM10, SO2, NO2</i>, truncate to integer
	 * <br>
	 * For <i>PM2.5, CO</i>, truncate to 1 decimal place
	 * <br>
	 * For <i>Ozone</i>, truncate to 3 decimal place
	 * 
	 * 
	 * @param pollutantCode the pollutant code (<i>PM10, PM2.5, O3, CO, NO2, SO2</i>)
	 * @param concentration the concentration
	 * @return the truncated pollutant concentration on pollutant code
	 */
	public double getTruncatedPollutantConcentrationOnPollutantCode(String pollutantCode, double concentration) {
		if (pollutantCode.equals(PM10) || pollutantCode.equals(SO2) || pollutantCode.equals(NO2)) {
			return Math.round(concentration);
		}
		else if (pollutantCode.equals(CO) || pollutantCode.equals(PM25)) {
			return Math.round(concentration * 10d) / 10d;
		}
		else {
			return Math.round(concentration * 1000d) / 1000d;
		}
	}

}
