package com.thanglequoc.aqicalculator;

import java.io.IOException;
import java.util.Optional;

/**
 * A calculator use to calculate AQI from pollutant concentration, support both
 * <b>regular AQI</b> calculation and <b>Nowcast AQI</b> calculation.
 * <p>
 * To use the <i>AQICalculator</i> object, get its instance by calling
 * <tt>getAQICalculatorInstance() </tt> method directly
 *
 * @author ThangLeQuoc
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
        pollutantBreakpoint = this.pollutantsBreakpoint.getBreakpointOfPollutant(pollutant);
        double truncatedConcentration = this.truncator.getTruncatedPollutantConcentrationBaseOnPollutant(pollutant,
                avgConcentration);
        targetPollutantConcentration = pollutantBreakpoint
                .getConcentrationRangeWithAvgConcentration(truncatedConcentration);

        if (targetPollutantConcentration.isPresent()) {
            return calculateAQIWithIndexAndConcentrationRange(avgConcentration, targetPollutantConcentration.get());
        } else {
            return -1;
        }

    }

    /**
     * Gets the aqi.
     *
     * @param pollutant        the pollutant code
     * @param avgConcentration the avg concentration
     * @return the aqi
     */
    public AQIResult getAQI(Pollutant pollutant, double avgConcentration) {
        pollutantBreakpoint = this.pollutantsBreakpoint.getBreakpointOfPollutant(pollutant);

        double truncatedConcentration = this.truncator.getTruncatedPollutantConcentrationBaseOnPollutant(pollutant,
                avgConcentration);
        targetPollutantConcentration = pollutantBreakpoint
                .getConcentrationRangeWithAvgConcentration(truncatedConcentration);
        int aqi = -1;
        String category = AQICalculatorConstants.UNCATEGORIZED;
        String generalAQIMessage = AQICalculatorConstants.INVALID_GENERAL_MESSAGE;
        String healthEffectsStatement = AQICalculatorConstants.NONE;
        String guidanceStatement = AQICalculatorConstants.NONE;

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

        return new AQIResult(pollutant, avgConcentration, aqi, category, generalAQIMessage, healthEffectsStatement,
                guidanceStatement);
    }

    /**
     * Gets the nowcast AQIResult object
     *
     * @param pollutant the pollutant code
     * @param data      the data
     * @return the nowcast AQI
     */
    public AQIResult getNowcastAQI(Pollutant pollutant, double[] data) {
        pollutantBreakpoint = this.pollutantsBreakpoint.getBreakpointOfPollutant(pollutant);
        double nowcastConcentration = nowcastCalculator.getNowcastConcentration(pollutant, data);
        int aqi = -1;
        String category = AQICalculatorConstants.UNCATEGORIZED;
        String generalAQIMessage = AQICalculatorConstants.INVALID_GENERAL_MESSAGE;
        String healthEffectsStatement = AQICalculatorConstants.NONE;
        String guidanceStatement = AQICalculatorConstants.NONE;

        if (nowcastConcentration >= 0) {
            // find the target Concentration with it corresponding Index level
            targetPollutantConcentration = pollutantBreakpoint
                    .getConcentrationRangeWithAvgConcentration(nowcastConcentration);
            if (targetPollutantConcentration.isPresent()) {
                aqi = calculateAQIWithIndexAndConcentrationRange(nowcastConcentration,
                        targetPollutantConcentration.get());
                GeneralAQIMessage generalMessage = messageGenerator.getGeneralAQIMessageObjectOnAQILevel(aqi);
                SpecificAQILevelMessage specificAQILevelMessage = messageGenerator
                        .getSpecifcAQILevelMessageOnAQILevelOfPollutant(pollutant, aqi);

                category = generalMessage.getCategory();
                generalAQIMessage = generalMessage.getMessage();
                healthEffectsStatement = specificAQILevelMessage.getHealthEffectsStatements();
                guidanceStatement = specificAQILevelMessage.getGuidance();
            }

        }
        return new AQIResult(pollutant, nowcastConcentration, aqi, category, generalAQIMessage, healthEffectsStatement,
                guidanceStatement);

    }

    private int calculateAQIWithIndexAndConcentrationRange(double rawConcentration,
                                                           PollutantConcentration concentration) {
        int iHigh = concentration.getIndex().getMaxIndex();
        int iLow = concentration.getIndex().getMinIndex();
        double cLow = concentration.getMinConcentration();
        double cHigh = concentration.getMaxConcentration();
        double rawAQI = (iHigh - iLow) / (cHigh - cLow) * (rawConcentration - cLow) + iLow;
        return (int) Math.round(rawAQI);
    }

}
