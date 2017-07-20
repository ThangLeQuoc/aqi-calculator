<h1 align="center">
	<br>
	<img width="320" src="https://cleanaircarolina.org/wp-content/uploads/2017/01/aqi_ex1.jpg" alt="aqi">
	<br>
  <br>
</h1>

# Maven AQI Calculator
## Highlights
- Calculate AQI from raw concentration
- Support Nowcast Concentration

### Support the following pollutants

| Pollutant  | Scientific name| Unit of Measurement |Input Code Usage |Nowcast Support
| ---- |:-------------:|:-------------:|:-------------:|:-------------:|
| PM10      |  10 μm Particle Pollutant  | μg/m3| PM10 |  :heavy_check_mark:
| PM2.5      |  2.5 μm Particle Pollutant  | μg/m3| PM2.5 |  :heavy_check_mark:
| O3     |  Ozone  | ppb| O3 |  :heavy_check_mark:
| CO     |  Carbon Monoxide  | ppb| CO |  :x:
| SO2     |  Sulfur Dioxide  | ppb| SO2 |  :x:
| NO2     |  Nitrogen Dioxide  | ppb| NO2 |  :x:
## Installation
Grab the target jar in `target-jar` folder and add the jar to your project

## Quick Usage

#### For Regular AQI Calculation
```
AQICalculator calculator = AQICalculator.getAQICalculatorInstance();
calculator.getAQIforPollutant("PM10", 134.12);
```
>90

#### For Nowcast AQI Calculation

~~~~
/* Example Data for Nowcast PM10 12h period - 64, 63, 72, 77, 65, 61, 70, 71, 64, 57, 58, 64 */
AQICalculator calculator = AQICalculator.getAQICalculatorInstance();

double[] data = { 64, 63, 72, 77, 65, 61, 70, 71, 64, 57, 58, 64 };`
calculator.getNowcastAQI("PM10", data);
~~~~
>57

The first value in the array is the avg value in the current hour, and the upcoming element in the array represent one step hour before current hour.

If the hour doesn't have data, replace missing data in the hour with **-1**
##### Example Nowcast Dataset for PM10: (have some missing data in hour)
| Hour | Avg Concentration 
| ---- |:-------------:|
| 14      | 64 ppb |
| 13      | 63 ppb |
| 12      | ---- |
| 11      | 77 ppb |
| 10      | 65 ppb |
| 9      | ---- |
| 8      | 70 ppb |
| 7      | 71 ppb |
| 6      | ---- |
| 5      | 57 ppb|
| 4      | 58 ppb|
| 3      | 64 ppb|

Presume that you want to calculate Nowcast AQI for PM10 at **14**, the data array should be

~~~~
double[] data = { 64, 63, -1, 77, 65, -1, 70, 71, -1, 57, 58, 64 };`
calculator.getNowcastAQI("PM10", data);
~~~~
>56

<br>
# AQI Turtorial Stuffs
**#comming soon**




