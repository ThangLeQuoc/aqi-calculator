package com.thanglequoc.aqicalculator;

import org.json.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;

/**
 * A calculator use to calculate AQI from pollutant concentration, support both
 * <b>regular AQI</b> calculation and <b>Nowcast AQI</b> calculation. This
 * object is intended to be a singleton object to avoid perfomance issue.
 * <p>
 * To use the <i>AQICalculator</i> object, get its instance by calling
 * <tt>getAQICalculatorInstance() </tt> method directly
 * 
 * @author ThangLeQuoc
 *
 */

public class AQICalculator {

    /** The breakpoint generator. */
    private PollutantsBreakpointGenerator breakpointGenerator;
    
    /** The AQI message generator  */
    private AQIMessageGenerator messageGenerator;
    
    /** The pollutants breakpoint. */
    private PollutantsBreakpoint pollutantsBreakpoint;

    /** The pollutant breakpoint. */
    private PollutantBreakpoint pollutantBreakpoint;

    /** The target pollutant concentration. */
    private PollutantConcentration targetPollutantConcentration;

    /** The nowcast calculator. */
    private NowcastCalculator nowcastCalculator;

    /** The truncator. */
    private PollutantConcentrationTruncator truncator;

    /** The unique AQI calculator instance. */
    private static AQICalculator uniqueAQICalculatorInstance;

    /**
     * Gets the AQI calculator instance.
     *
     * @return the AQI calculator instance
     */
    public static AQICalculator getAQICalculatorInstance() {
	if (uniqueAQICalculatorInstance == null) {
	    uniqueAQICalculatorInstance = new AQICalculator();
	}
	return uniqueAQICalculatorInstance;
    }

    /**
     * Instantiates a new AQI calculator.
     */
    private AQICalculator() {
	/*
	 * Constructor, AQI Calculator will generate the following thing
	 * PollutantBreakpointGenerator: Generator to get the breakpoints table
	 * from JSON File PollutantsBreakpoint: Store a list of pollutant
	 * breakpoint Nowcast Calculator: calculator to get avgAQI at present
	 * for PM10, PM2.5, Ozone
	 */

	try {
	    this.breakpointGenerator = new PollutantsBreakpointGenerator();
	    this.messageGenerator = new AQIMessageGenerator();
	    
	} catch (Exception e) {
	 
	    e.printStackTrace();
	} 
	this.pollutantsBreakpoint = breakpointGenerator.getPollutantsBreakpoint();
	this.nowcastCalculator = new NowcastCalculator();
	this.truncator = new PollutantConcentrationTruncator();
    }

    /**
     * @deprecated Gets the AQIResult for pollutant.
     *
     * @param pollutantCode
     *            the pollutant code
     * @param avgConcentration
     *            the avg concentration
     * @return the AQI for pollutant
     */
    /*
     * Method: Return AQI for selected Pollutant
     * 
     * @ pollutantCode: Pollutant Code to calculate the AQI (ex: PM10, PM2.5,
     * SO2, ....)
     * 
     * @ avgConcentration: Average Concentration
     **/

    @Deprecated
    public int getAQIforPollutant(String pollutantCode, double avgConcentration) {
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
    
    private int calculateAQI(String pollutantCode, double avgConcentration) {
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

    public AQIResult getAQI(String pollutantCode, double avgConcentration) {
	pollutantBreakpoint = this.pollutantsBreakpoint.getPollutantBreakpointByCode(pollutantCode);

	double truncatedConcentration = this.truncator.getTruncatedPollutantConcentrationOnPollutantCode(pollutantCode,
		avgConcentration);
	// find the target Concentration with it corresponding Index level
	targetPollutantConcentration = pollutantBreakpoint.getConcentrationRangeWithAvgConcentration(truncatedConcentration);

	int i_high = targetPollutantConcentration.getIndex().getMaxIndex();
	int i_low = targetPollutantConcentration.getIndex().getMinIndex();
	double c_low = targetPollutantConcentration.getMinConcentration();
	double c_high = targetPollutantConcentration.getMaxConcentration();

	// perform the calculation formula
	double result = (i_high - i_low) / (c_high - c_low) * (avgConcentration - c_low) + i_low;

	/* Air Quality Index */
	int aqi = calculateAQI(pollutantCode, avgConcentration);
	
	GeneralAQIMessage generalMessage = messageGenerator.getGeneralAQIMessageObjectOnAQILevel(aqi);
	SpecificAQILevelMessage specificAQILevelMessage = messageGenerator.getSpecifcAQILevelMessageOnAQILevelOfPollutant(pollutantCode, aqi);
	
	String category = generalMessage.getCategory();
	String generalAQIMessage = generalMessage.getMessage();
	String healthEffectsStatement = specificAQILevelMessage.getHealthEffectsStatements();
	String guidanceStatement = specificAQILevelMessage.getGuidance();
	
	return new AQIResult(aqi, category, generalAQIMessage, healthEffectsStatement, guidanceStatement);
    }

    /**
     * Gets the nowcast AQI.
     *
     * @param pollutantCode
     *            the pollutant code
     * @param data
     *            the data
     * @return the nowcast AQI
     */
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
