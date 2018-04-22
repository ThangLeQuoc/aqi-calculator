package com.thanglequoc.aqicalculator;

import java.io.IOException;
import java.util.Optional;

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

    private PollutantsBreakpointGenerator breakpointGenerator;

    private AQIMessageGenerator messageGenerator;

    private PollutantsBreakpoint pollutantsBreakpoint;

    private PollutantBreakpoint pollutantBreakpoint;

    private Optional<PollutantConcentration> targetPollutantConcentration;

    private NowcastCalculator nowcastCalculator;

    private PollutantConcentrationTruncator truncator;

    private static AQICalculator uniqueAQICalculatorInstance;

    /**
     * Get the AQI calculator instance.
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
	 * AQI Calculator will generate the following thing
	 * PollutantBreakpointGenerator: Generator to get the breakpoints table
	 * from JSON File PollutantsBreakpoint: Store a list of pollutant
	 * breakpoint Nowcast Calculator: calculator to get avgAQI at present
	 * for PM10, PM2.5, Ozone
	 */

	try {
	    this.breakpointGenerator = new PollutantsBreakpointGenerator();
	    this.messageGenerator = new AQIMessageGenerator();

	} catch (IOException e) {
	    e.printStackTrace();
	}
	this.pollutantsBreakpoint = breakpointGenerator.getPollutantsBreakpoint();
	this.nowcastCalculator = new NowcastCalculator();
	this.truncator = new PollutantConcentrationTruncator();
    }

    private int calculateAQI(Pollutant pollutant, double avgConcentration) {
	pollutantBreakpoint = this.pollutantsBreakpoint.getPollutantBreakpointByCode(pollutant);

	if (avgConcentration < 0) {
	    return -1;
	} else {
	    double truncatedConcentration = this.truncator.getTruncatedPollutantConcentrationBaseOnPollutant(pollutant,
		    avgConcentration);
	    targetPollutantConcentration = pollutantBreakpoint
		    .getConcentrationRangeWithAvgConcentration(truncatedConcentration);

	    if (targetPollutantConcentration.isPresent()) {
		int iHigh = targetPollutantConcentration.get().getIndex().getMaxIndex();
		int iLow = targetPollutantConcentration.get().getIndex().getMinIndex();
		double cLow = targetPollutantConcentration.get().getMinConcentration();
		double cHigh = targetPollutantConcentration.get().getMaxConcentration();

		double result = (iHigh - iLow) / (cHigh - cLow) * (avgConcentration - cLow) + iLow;

		/* AQI Rule: the result is rounded to the nearest integer */
		return (int) Math.round(result);
	    } else
		return -1;
	}
    }

    /**
     * Gets the aqi.
     *
     * @param pollutant
     *            the pollutant code
     * @param avgConcentration
     *            the avg concentration
     * @return the aqi
     */
    public AQIResult getAQI(Pollutant pollutant, double avgConcentration) {
	pollutantBreakpoint = this.pollutantsBreakpoint.getPollutantBreakpointByCode(pollutant);

	double truncatedConcentration = this.truncator.getTruncatedPollutantConcentrationBaseOnPollutant(pollutant,
		avgConcentration);
	targetPollutantConcentration = pollutantBreakpoint
		.getConcentrationRangeWithAvgConcentration(truncatedConcentration);
	int aqi = -1;
	String category = InvalidMessage.INVALID_CATEGORY.getLiteral();
	String generalAQIMessage = InvalidMessage.INVALID_GENERAL_MESSAGE.getLiteral();
	String healthEffectsStatement = InvalidMessage.INVALID_HEALTH_EFFECTS_STATEMENTS_MESSAGE.getLiteral();
	String guidanceStatement = InvalidMessage.INVALID_GUIDANCE_MESSAGE.getLiteral();

	if (targetPollutantConcentration.isPresent()) {
	    aqi = calculateAQI(pollutant, avgConcentration);
	    GeneralAQIMessage generalMessage = messageGenerator.getGeneralAQIMessageObjectOnAQILevel(aqi);
	    SpecificAQILevelMessage specificAQILevelMessage = messageGenerator
		    .getSpecifcAQILevelMessageOnAQILevelOfPollutant(pollutant, aqi);

	    category = generalMessage.getCategory();
	    generalAQIMessage = generalMessage.getMessage();
	    healthEffectsStatement = specificAQILevelMessage.getHealthEffectsStatements();
	    guidanceStatement = specificAQILevelMessage.getGuidance();

	}

	return new AQIResult(aqi, category, generalAQIMessage, healthEffectsStatement, guidanceStatement);
    }

    /**
     * Gets the nowcast AQIResult object
     *
     * @param pollutant
     *            the pollutant code
     * @param data
     *            the data
     * @return the nowcast AQI
     */
    public AQIResult getNowcastAQI(Pollutant pollutant, double[] data) {
	pollutantBreakpoint = this.pollutantsBreakpoint.getPollutantBreakpointByCode(pollutant);

	double nowcastConcentration = nowcastCalculator.getNowcastConcentration(pollutant, data);
	int aqi = -1;
	String category = InvalidMessage.INVALID_CATEGORY.getLiteral();
	String generalAQIMessage = InvalidMessage.INVALID_GENERAL_MESSAGE.getLiteral();
	String healthEffectsStatement = InvalidMessage.INVALID_HEALTH_EFFECTS_STATEMENTS_MESSAGE.getLiteral();
	String guidanceStatement = InvalidMessage.INVALID_GUIDANCE_MESSAGE.getLiteral();

	// check if the nowcast has a valid data , if not, return aqi = -1
	if (nowcastConcentration < 0) {
	    return new AQIResult(aqi, category, generalAQIMessage, healthEffectsStatement, guidanceStatement);
	} else {
	    // find the target Concentration with it corresponding Index level
	    targetPollutantConcentration = pollutantBreakpoint
		    .getConcentrationRangeWithAvgConcentration(nowcastConcentration);
	    if (targetPollutantConcentration.isPresent()) {
		int iHigh = targetPollutantConcentration.get().getIndex().getMaxIndex();
		int iLow = targetPollutantConcentration.get().getIndex().getMinIndex();
		double cLow = targetPollutantConcentration.get().getMinConcentration();
		double cHigh = targetPollutantConcentration.get().getMaxConcentration();

		double result = (iHigh - iLow) / (cHigh - cLow) * (nowcastConcentration - cLow) + iLow;

		aqi = (int) Math.round(result);
		GeneralAQIMessage generalMessage = messageGenerator.getGeneralAQIMessageObjectOnAQILevel(aqi);
		SpecificAQILevelMessage specificAQILevelMessage = messageGenerator
			.getSpecifcAQILevelMessageOnAQILevelOfPollutant(pollutant, aqi);

		category = generalMessage.getCategory();
		generalAQIMessage = generalMessage.getMessage();
		healthEffectsStatement = specificAQILevelMessage.getHealthEffectsStatements();
		guidanceStatement = specificAQILevelMessage.getGuidance();
	    }

	    return new AQIResult(aqi, category, generalAQIMessage, healthEffectsStatement, guidanceStatement);
	}

    }

}
