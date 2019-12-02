package com.joshMayfield.adventofcode.twentynineteen.day1TyrannyRocket;

import com.joshMayfield.adventofcode.AdventOfCodeFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdventSolutionDay1 {

    private static final int DIVISOR = 3;
    private static final int SUBTRACTED = 2;

    @Autowired
    private AdventOfCodeFileUtils fileUtils;

    //@PostConstruct
    public void findSolution() {
        List<String> input = fileUtils.readFile("2019", this.getClass());
        solvePart1(input);
        solvePart2(input);
    }

    private void solvePart1(List<String> input) {
        Integer totalFuelValue = 0;

        for (String mass : input) {
            totalFuelValue += getFuelValue(Integer.valueOf(mass));
        }

        System.out.println("(Part 1) Total Fuel Value: " + totalFuelValue);
    }

    private void solvePart2(List<String> input) {
        Integer totalFuelValue = 0;

        for (String mass : input) {
            totalFuelValue += getRealFuelValue(Integer.valueOf(mass));
        }

        System.out.println("(Part 2) Total Fuel Value: " + totalFuelValue);
    }

    private Integer getRealFuelValue(Integer value) {
        Integer fuelValue = getFuelValue(value);
        if (fuelValue > 0) {
            return fuelValue + getRealFuelValue(fuelValue);
        } else {
            return 0;
        }
    }

    private Integer getFuelValue(Integer value) {
        return (Math.floorDiv(value, DIVISOR)) - SUBTRACTED;
    }
}
