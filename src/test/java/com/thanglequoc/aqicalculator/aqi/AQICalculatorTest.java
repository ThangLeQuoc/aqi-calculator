package com.thanglequoc.aqicalculator.aqi;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.thanglequoc.aqicalculator.AQICalculator;
import com.thanglequoc.aqicalculator.PollutantCode;




public class AQICalculatorTest {

    	//@InjectMocks
	AQICalculator calculator;

    	
    	private String pollutantCode;

	@Before
	public void begin() throws IOException, Exception {
	    this.pollutantCode = "";
	    calculator = AQICalculator.getAQICalculatorInstance();
	}

	/**
	 * --------------Begin of AQI Test for PM10-------------------------------------------
	 **/

	@Test
	public void should_ReturnPM10AQI_When_InputConcentration() {
		pollutantCode = PollutantCode.PM10.getLiteral();
		double concentration = 135;
		int expectedAQI = 91;

		int actualAQI = this.calculator.getAQIforPollutant(pollutantCode, concentration);
		assertEquals(expectedAQI, actualAQI);

		concentration = 175;
		expectedAQI = 111;
		actualAQI = this.calculator.getAQIforPollutant(pollutantCode, concentration);
		assertEquals(expectedAQI, actualAQI);

		concentration = 357;
		expectedAQI = 204;
		actualAQI = this.calculator.getAQIforPollutant(pollutantCode, concentration);
		assertEquals(expectedAQI, actualAQI);
	}

	@Test
	public void should_ReturnPM10NoAQI_When_InputInvalidConcentration() {
		this.pollutantCode = PollutantCode.PM10.getLiteral();
		double concentration = -1;
		int expectedAQI = -1;
		int actualAQI = this.calculator.getAQIforPollutant(pollutantCode, concentration);
		assertEquals(expectedAQI, actualAQI);
	}

	@Test
	public void should_ReturnEqualsPM10NowcastAQI_When_InputListOfConcentration() {
		/**
		 * Example Data for Nowcast PM10 12h period - 64, 63, 72, 77, 65, 61,
		 * 70, 71, 64, 57, 58, 64
		 **/
		this.pollutantCode = PollutantCode.PM10.getLiteral();
		double[] data = { 64, 63, 72, 77, 65, 61, 70, 71, 64, 57, 58, 64 };
		int expectedAQI = 57;
		int actualAQI = this.calculator.getNowcastAQI(pollutantCode, data);
		assertEquals(expectedAQI, actualAQI);
	}

	@Test
	public void should_ReturnEqualsPM10NowcastAQI_When_InputValidListOfMissingConcentration() {
		
		this.pollutantCode = PollutantCode.PM10.getLiteral();
		double[] data = { 64, -1, 62, 77, 65, 61, 70, 71, 64, 57, 58, 64 };
		int expectedAQI = 56;
		int actualAQI = this.calculator.getNowcastAQI(pollutantCode, data);
		assertEquals(expectedAQI, actualAQI);

		// Only some data available
		double[] data2 = { 165, 123, 45, 12, -1, -1, -1, -1, -1, 123, 154, -1 };
		expectedAQI = 87;
		actualAQI = this.calculator.getNowcastAQI(pollutantCode, data2);
		assertEquals(expectedAQI, actualAQI);

	}

	@Test
	public void shoud_ReturnPM10NoNowcastAQI_When_InputInvalidListOfMissingConcentration() {
		this.pollutantCode = PollutantCode.PM10.getLiteral();
		// missing 3 nearest hour of data
		double[] data = {-1, -1, -1, 77, 65, 61, 70, 71, 64, 57, 58, 64 };
		int expectedAQI = -1;
		int actualAQI = this.calculator.getNowcastAQI(pollutantCode, data);
		
		assertEquals(expectedAQI, actualAQI);
		
		/**
		 * Example Data for Nowcast PM10 12h period - 64, -1, -1, 77, 65, 61,
		 * 70, 71, 64, 57, 58, 64 , missing 2 of 3 nearest data -> invalid
		 **/
		this.pollutantCode = PollutantCode.PM10.getLiteral();
		double[] data2 = { 64, -1, -1, 77, 65, 61, 70, 71, 64, 57, 58, 64 };
		expectedAQI = -1;
		actualAQI = this.calculator.getNowcastAQI(pollutantCode, data2);
		assertEquals(expectedAQI, actualAQI);
	}

	/**
	 * --------------Begin of AQI Test for PM2.5-------------------------------------------
	 **/

	@Test
	public void should_ReturnPM25AQI_When_InputConcentration(){
		this.pollutantCode = PollutantCode.PM25.getLiteral();
		
		int concentration = 35;
		int expectedAQI = 99;
		int actualAQI = this.calculator.getAQIforPollutant(pollutantCode, concentration);
		assertEquals(expectedAQI, actualAQI);
		
		concentration = 78;
		expectedAQI = 163;
		actualAQI = this.calculator.getAQIforPollutant(pollutantCode, concentration);
		assertEquals(expectedAQI, actualAQI);
		
		concentration = 12;
		expectedAQI = 50;
		actualAQI = this.calculator.getAQIforPollutant(pollutantCode, concentration);
		assertEquals(expectedAQI, actualAQI);
	}
	
	@Test
	public void should_ReturnPM25NoAQI_When_InputInvalidConcentration(){
		this.pollutantCode = PollutantCode.PM25.getLiteral();
		int concentration = -1;
		int expectedAQI = -1;
		int actualAQI = this.calculator.getAQIforPollutant(pollutantCode, concentration);
		assertEquals(expectedAQI, actualAQI);
	}
	
	@Test
	public void should_ReturnPM25NowcastAQI_When_InputListOfConcentration() {
		/***
		 * 
		 * */
		this.pollutantCode = PollutantCode.PM25.getLiteral();
		double[] data = { 30.5, 28.8, 29.5, 30, 32.4, 31.1, 28.2, 30.7, 32.8, 32.6, 33.1, 28.5 };
		int expectedAQI = 89;
		int actualAQI = this.calculator.getNowcastAQI(pollutantCode, data);
		assertEquals(expectedAQI, actualAQI);

		double[] data2 = { 165, 123, 45, 12, 45, 12, 56, 42, 12, 123, 154, 32 };
		expectedAQI = 185;
		actualAQI = this.calculator.getNowcastAQI(pollutantCode, data2);
		assertEquals(expectedAQI, actualAQI);
	}

	@Test
	public void shoud_ReturnPM25NowcastAQI_When_InputValidListOfMissingConcentration() {
		this.pollutantCode = PollutantCode.PM25.getLiteral();

		/**
		 * Example Data for Nowcast PM2.5 12h period - missing 1 of the nearest
		 * 3 hours -> still valid
		 **/
		double[] data = { 30.5, 12.5, -1, 30, 32.4, 31.1, 28.2, 30.7, 32.8, 32.6, 33.1, 28.5 };
		int expectedAQI = 79;
		int actualAQI = this.calculator.getNowcastAQI(pollutantCode, data);
		assertEquals(expectedAQI, actualAQI);
	}
	
	@Test
	public void shoud_ReturnPM25NoNowcastAQI_When_InputInvalidListOfMissingConcentration(){
		this.pollutantCode = PollutantCode.PM25.getLiteral();
		double[] data = { 30.5, -1, -1, 30, 32.4, 31.1, 28.2, 30.7, 32.8, 32.6, 33.1, 28.5 };
		int expectedAQI = -1; // no AQI
		int actualAQI = this.calculator.getNowcastAQI(pollutantCode, data);
		assertEquals(expectedAQI, actualAQI);
		
		double[] data2 = {-1, -1, -1, 30, 32.4, 31.1, 28.2, 30.7, 32.8, 32.6, 33.1, 28.5};
		expectedAQI = -1;
		actualAQI = this.calculator.getNowcastAQI(pollutantCode, data2);
		assertEquals(expectedAQI, actualAQI);
	}
	
	/***
	 * --------------Begin of AQI Test for Ozone-------------------------------------------
	 * */
	@Test
	public void should_ReturnOzoneAQI_When_InputConcentration(){
		this.pollutantCode = PollutantCode.O3.getLiteral();
		double concentration = 45;
		int expectedAQI = 42;
		int actualAQI = this.calculator.getAQIforPollutant(pollutantCode, concentration);
		assertEquals(expectedAQI, actualAQI);
		
		
		
		concentration = 89;
		expectedAQI = 159;
		actualAQI = this.calculator.getAQIforPollutant(pollutantCode, concentration);
		assertEquals(expectedAQI, actualAQI);
		
		
		concentration = 72.71875;
		expectedAQI = 107;
		actualAQI = this.calculator.getAQIforPollutant(pollutantCode, concentration);
		assertEquals(expectedAQI, actualAQI);
		
		
	}
	
	@Test
	public void should_ReturnOzoneNoAQI_When_InputInvalidConcentration(){
		this.pollutantCode = PollutantCode.O3.getLiteral();
		double concentration = -1;
		int expectedAQI = -1;
		int actualAQI = this.calculator.getAQIforPollutant(pollutantCode, concentration);
		assertEquals(expectedAQI, actualAQI);
	}

	@Test
	public void should_ReturnOzoneNowcastAQI_When_InputListOfConcentration(){
		this.pollutantCode = PollutantCode.O3.getLiteral();
		double[] data = { 38.611, 47.406, 54.469, 52.377, 50.754, 43.373, 39.143, 35.334 };
		int expectedAQI = 42;
		int actualAQI = this.calculator.getNowcastAQI(pollutantCode, data);
		assertEquals(expectedAQI, actualAQI);
		
		double[] data1 = {42.12, 32.12,34.12,-1,-1,-1,-1,-1};
		actualAQI = this.calculator.getNowcastAQI(pollutantCode, data1);
		expectedAQI = 34;
		assertEquals(expectedAQI, actualAQI);
		
	}
	
	@Test
	public void shoud_ReturnOzoneNowcastAQI_When_InputValidListOfMissingConcentration(){
		this.pollutantCode = PollutantCode.O3.getLiteral();
		
		double[] data = { 145.32, 167.54, 187.12, 123.12, -1, -1, -1, -1 };
		int expectedAQI = 254;
		int actualAQI = this.calculator.getNowcastAQI(pollutantCode, data);
		assertEquals(expectedAQI, actualAQI);
		
		double[] data2 = {145.32, 167.54, -1, 123.12, 0, 183.2, 32.4, 145.3};
		expectedAQI = 242;
		actualAQI = this.calculator.getNowcastAQI(pollutantCode, data2);
		assertEquals(expectedAQI, actualAQI);
		
		double[] data3 = { -1, 47.406, 54.469, 52.377, 50.754, 43.373, 39.143, 35.334 };
		expectedAQI = 46;
		actualAQI = this.calculator.getNowcastAQI(pollutantCode, data3);
		assertEquals(expectedAQI, actualAQI);
		
	}

	@Test
	public void shoud_ReturnOzoneNoNowcastAQI_When_InputInvalidListOfMissingConcentration(){
		this.pollutantCode = PollutantCode.O3.getLiteral();
		double[] data = {-1,-1,-1,12,45,12,45,56};
		int expectedAQI = -1;
		int actualAQI = this.calculator.getNowcastAQI(pollutantCode, data);
		assertEquals(expectedAQI, actualAQI);
		
		double[] data2 = {-1,-1,1,12,45,12,45,56};
		expectedAQI = -1;
		actualAQI = this.calculator.getNowcastAQI(pollutantCode, data2);
		assertEquals(expectedAQI, actualAQI);
	}

	
	/***
	 * --------------Begin of AQI Test for CO-------------------------------------------
	 * */
	@Test
	public void should_ReturnCOAQI_When_InputConcentration() {
		this.pollutantCode = PollutantCode.CO.getLiteral();
		double concentration = 12000;
		int expectedAQI = 143;
		int actualAQI = this.calculator.getAQIforPollutant(pollutantCode, concentration);
		assertEquals(expectedAQI, actualAQI);

		concentration = 7000;
		expectedAQI = 76;
		actualAQI = this.calculator.getAQIforPollutant(pollutantCode, concentration);
		assertEquals(expectedAQI, actualAQI);
	}
	
	@Test
	public void should_ReturnCONoAQI_When_InputInvalidConcentration(){
		this.pollutantCode = PollutantCode.CO.getLiteral();
		double concentration = -1;
		int expectedAQI = -1;
		int actualAQI = this.calculator.getAQIforPollutant(pollutantCode, concentration);
		assertEquals(expectedAQI, actualAQI);
	}
	
	
	/**
	 * --------------Begin of AQI Test for NO2-------------------------------------------
	 */

	@Test
	public void should_ReturnNO2AQI_When_InputConcentration() {
		this.pollutantCode = PollutantCode.NO2.getLiteral();
		double concentration = 145.12;
		int expectedAQI = 109;
		int actualAQI = this.calculator.getAQIforPollutant(pollutantCode, concentration);
		assertEquals(expectedAQI, actualAQI);

		concentration = 43;
		expectedAQI = 41;
		actualAQI = this.calculator.getAQIforPollutant(pollutantCode, concentration);
		assertEquals(expectedAQI, actualAQI);
	}
	
	@Test
	public void should_ReturnNO2NoAQI_When_InputInvalidConcentration(){
		this.pollutantCode = PollutantCode.NO2.getLiteral();
		double concentration = -1;
		int expectedAQI = -1;
		int actualAQI = this.calculator.getAQIforPollutant(pollutantCode, concentration);
		assertEquals(expectedAQI, actualAQI);
	}


	/***
	 * --------------Begin of AQI Test for SO2-------------------------------------------
	 */
	
	@Test
	public void should_ReturnSO2AQI_When_InputConcentration() {
		this.pollutantCode = PollutantCode.SO2.getLiteral();
		double concentration = 132;
		int expectedAQI = 126;
		int actualAQI = this.calculator.getAQIforPollutant(pollutantCode, concentration);
		assertEquals(expectedAQI, actualAQI);

		concentration = 42;
		expectedAQI = 59;
		actualAQI = this.calculator.getAQIforPollutant(pollutantCode, concentration);
		assertEquals(expectedAQI, actualAQI);
	}
	
	@Test
	public void should_ReturnSO2NoAQI_When_InputInvalidConcentration(){
		this.pollutantCode = PollutantCode.SO2.getLiteral();
		double concentration = -1;
		int expectedAQI = -1;
		int actualAQI = this.calculator.getAQIforPollutant(pollutantCode, concentration);
		assertEquals(expectedAQI, actualAQI);
	}
}
