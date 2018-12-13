package com.thanglequoc.aqicalculator;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

class PollutantBreakpointParser {

    PollutantBreakpoint parseNode(JsonNode node) {
        String code = node.path(AQICalculatorConstants.CODE).asText();
        Pollutant pollutant = Pollutant.parseFromString(code);
        String unit = node.path(AQICalculatorConstants.UNIT).asText();
        String period = node.path(AQICalculatorConstants.PERIOD).asText();
        PollutantBreakpoint pollutantBreakpoint = new PollutantBreakpoint(pollutant, unit, period);

        List<PollutantConcentration> concentrationList = new ArrayList<>();

        JsonNode concentrationArray = node.path(AQICalculatorConstants.CONCENTRATIONS);
        for (JsonNode concentrationNode : concentrationArray) {
            double minConcentration = concentrationNode.path(AQICalculatorConstants.MIN).asDouble();
            double maxConcentration = concentrationNode.path(AQICalculatorConstants.MAX).asDouble();

            Index index = Index.fromIndexNode(concentrationNode.path(AQICalculatorConstants.INDEX));

            PollutantConcentration concentration = new PollutantConcentration(index, minConcentration,
                    maxConcentration);
            concentrationList.add(concentration);
        }

        pollutantBreakpoint.setPollutantConcentrations(concentrationList);

        return pollutantBreakpoint;
    }

}
