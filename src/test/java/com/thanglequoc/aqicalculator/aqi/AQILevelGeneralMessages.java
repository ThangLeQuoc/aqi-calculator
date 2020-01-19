package com.thanglequoc.aqicalculator.aqi;

enum AQILevelGeneralMessages {
    INVALID("Invalid pollutant concentration range for calculation"),
    GOOD("Air quality is considered satisfactory, and air pollution poses little or no risk"),
    MODERATE("Air quality is acceptable; however, for some pollutants there may be a moderate health concern for a very small number of people who are unusually sensitive to air pollution"),
    UNHEALTHY_FOR_SENSITIVE_GROUPS("Members of sensitive groups may experience health effects. The general public is not likely to be affected"),
    UNHEALTHY("Everyone may begin to experience health effects; members of sensitive groups may experience more serious health effects"),
    VERY_UNHEALTHY("Health alert: everyone may experience more serious health effects"),
    HAZARDOUS("Health warnings of emergency conditions. The entire population is more likely to be affected");
    
    
    private String meaning;
    
    AQILevelGeneralMessages(String meaning) {
        this.meaning = meaning;
    }
    
    /**
     * Gets the meaning message.
     *
     * @return the meaning message
     */
    public String getMeaning() {
        return meaning;
    }
}
