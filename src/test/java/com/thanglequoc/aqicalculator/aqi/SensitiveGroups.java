package com.thanglequoc.aqicalculator.aqi;

import com.thanglequoc.aqicalculator.Pollutant;

enum SensitiveGroups {

    PM25(Pollutant.PM25, "People with respiratory or heart disease, the elderly and children are the groups most at risk"),
    PM10(Pollutant.PM10, "People with respiratory disease are the group most at risk"),
    O3(Pollutant.O3, "Children and people with asthma are the groups most at risk"),
    CO(Pollutant.CO, "People with heart disease are the group most at risk"),
    SO2(Pollutant.SO2, "People with asthma are the group most at risk"),
    NO2(Pollutant.NO2, "People with asthma or other respiratory diseases, the elderly, and children are the groups most at risk")
    ;

    private String sensitiveGroups;
    private Pollutant pollutant;

    SensitiveGroups(Pollutant pollutant, String sensitiveGroups) {
        this.pollutant = pollutant;
        this.sensitiveGroups = sensitiveGroups;
    }

    String getSensitiveGroups() {
        return sensitiveGroups;
    }

    Pollutant getPollutant() {
        return pollutant;
    }

    static String getSensitiveGroups(Pollutant pollutant) {
        for (SensitiveGroups sensitiveGroups: SensitiveGroups.values()) {
            if (sensitiveGroups.getPollutant().equals(pollutant)) {
                return sensitiveGroups.getSensitiveGroups();
            }
        }
        return null;
    }
}
