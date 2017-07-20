package com.thanglequoc.aqicalculator;

import org.json.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;

public class AQICalculator {
	private PollutantsBreakpointGenerator breakpointGenerator;
	private PollutantsBreakpoint pollutantsBreakpoint;
	private PollutantBreakpoint pollutantBreakpoint;
	private PollutantConcentration targetPollutantConcentration;
	private NowcastCalculator nowcastCalculator;
	private PollutantConcentrationTruncator truncator;
	
	private static AQICalculator uniqueAQICalculatorInstance;
	
	 public static AQICalculator getAQICalculatorInstance(){
		if(uniqueAQICalculatorInstance == null){
		    uniqueAQICalculatorInstance = new AQICalculator();
		}
		return uniqueAQICalculatorInstance;
	    }

	 private AQICalculator()    {
		/*
		 * Constructor, AQI Calculator will generate the following thing
		 * PollutantBreakpointGenerator: Generator to get the breakpoints table
		 * from JSON File PollutantsBreakpoint: Store a list of pollutant
		 * breakpoint Nowcast Calculator: calculator to get avgAQI at present
		 * for PM10, PM2.5, Ozone
		 */

		try {
		    this.breakpointGenerator = new PollutantsBreakpointGenerator();
		} catch (JsonProcessingException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		this.pollutantsBreakpoint = breakpointGenerator.getPollutantsBreakpoint();
		this.nowcastCalculator = new NowcastCalculator();
		this.truncator = new PollutantConcentrationTruncator();
	    }

	/*
	 * Method: Return AQI for selected Pollutant
	 * 
	 * @ pollutantCode: Pollutant Code to calculate the AQI (ex: PM10, PM2.5,
	 * SO2, ....)
	 * 
	 * @ avgConcentration: Average Concentration
	 **/
	public int getAQIforPollutant(String pollutantCode, double avgConcentration) {
		// Get the breakpoint on pollutant code (ex: PM2.5 breakpoint, Ozone
		// breakpoint)
		pollutantBreakpoint = this.pollutantsBreakpoint.getPollutantBreakpointByCode(pollutantCode);

		if (avgConcentration < 0) {
			return -1;
		} else {
			double truncatedConcentration = this.truncator
					.getTruncatedPollutantConcentrationOnPollutantCode(pollutantCode, avgConcentration);
			// find the target Concentration with it corresponding Index level
			targetPollutantConcentration = pollutantBreakpoint
					.getConcentrationRangeWithAvgConcentration(truncatedConcentration);

			int i_high = targetPollutantConcentration.getIndex().getMaxIndex();
			int i_low = targetPollutantConcentration.getIndex().getMinIndex();
			double c_low = targetPollutantConcentration.getMinConcentration();
			double c_high = targetPollutantConcentration.getMaxConcentration();

			// perform the calculation formula
			double result = (i_high - i_low) / (c_high - c_low) * (avgConcentration - c_low) + i_low;

			// round it to the nearest integer, and return
			return (int) Math.round(result);
		}

	}

	public int getNowcastAQI(String pollutantCode, double[] data) {
		// Get the breakpoint on pollutant code (ex: SO2, NO2
		// breakpoint)
		pollutantBreakpoint = this.pollutantsBreakpoint.getPollutantBreakpointByCode(pollutantCode);

		double nowcastConcentration = nowcastCalculator.getNowcastConcentration(pollutantCode, data);

		// check if the nowcast has a valid data , if not, return aqi = -1
		if (nowcastConcentration < 0) {
			return -1;
		} else {
			// find the target Concentration with it corresponding Index level
			targetPollutantConcentration = pollutantBreakpoint
					.getConcentrationRangeWithAvgConcentration(nowcastConcentration);

			int i_high = targetPollutantConcentration.getIndex().getMaxIndex();
			int i_low = targetPollutantConcentration.getIndex().getMinIndex();
			double c_low = targetPollutantConcentration.getMinConcentration();
			double c_high = targetPollutantConcentration.getMaxConcentration();

			// perform the calculation formula
			double result = (i_high - i_low) / (c_high - c_low) * (nowcastConcentration - c_low) + i_low;

			// round it to the nearest integer, and return
			return (int) Math.round(result);
		}

	}

}
