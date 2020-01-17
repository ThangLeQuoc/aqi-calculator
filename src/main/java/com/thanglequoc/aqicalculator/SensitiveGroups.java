package com.thanglequoc.aqicalculator;

class SensitiveGroups {

    private Pollutant pollutant;
    private String sensitiveGroups;

    SensitiveGroups(Pollutant pollutant, String sensitiveGroups) {
        this.pollutant = pollutant;
        this.sensitiveGroups = sensitiveGroups;
    }

    Pollutant getPollutant() {
        return pollutant;
    }

    String getSensitiveGroups() {
        return sensitiveGroups;
    }
}
