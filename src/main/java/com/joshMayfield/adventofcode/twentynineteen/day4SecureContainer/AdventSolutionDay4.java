package com.joshMayfield.adventofcode.twentynineteen.day4SecureContainer;

import com.joshMayfield.adventofcode.AdventOfCodeFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class AdventSolutionDay4 {

    private static final Integer MIN_PW_RNG = 264360;
    private static final Integer MAX_PW_RNG = 746325;
    private static Integer numOfOptions;

    @Autowired
    private AdventOfCodeFileUtils fileUtils;

    @PostConstruct
    public void findSolution() {
        numOfOptions = 0;
        solvePart1();
        solvePart2();
    }

    private void solvePart1() {
        for (int i = MIN_PW_RNG; i <= MAX_PW_RNG; i++) {
            if (adjacentSimilarityCheck(i) && neverDecreasingCheck(i)) {
                numOfOptions++;
            }
        }

        System.out.println("Number of Options: " + numOfOptions);
    }

    private void solvePart2() {
        numOfOptions = 0;

        for (int i = MIN_PW_RNG; i <= MAX_PW_RNG; i++) {
            if (hasOneAdjacent(i) && neverDecreasingCheck(i)) {
                numOfOptions++;
            }
        }

        System.out.println("Number of Options: " + numOfOptions);
    }

    private boolean adjacentSimilarityCheck(Integer value) {
        char[] valueArray = String.valueOf(value).toCharArray();
        boolean isAdjacentSimilar = false;

        for (int i = 0; i < valueArray.length; i++) {
            if (i == 0) {
                if (doesNextValueEqual(valueArray, i)) {
                    isAdjacentSimilar = true;
                    break;
                }
            } else if (i == (valueArray.length - 1)) {
                if (doesPreviousValueEqual(valueArray, i)) {
                    isAdjacentSimilar = true;
                    break;
                }
            } else {
                if (doesPreviousValueEqual(valueArray, i) || doesNextValueEqual(valueArray, i)) {
                    isAdjacentSimilar = true;
                    break;
                }
            }
        }

        return isAdjacentSimilar;
    }

    private boolean hasOneAdjacent(Integer value) {
        char[] valueArray = String.valueOf(value).toCharArray();
        boolean hasOneAdjacent = false;

        for (int i = 0; i < valueArray.length; i++) {
            if (i == 0) {
                if (doesNextValueEqual(valueArray, i) && !doesTwoValuesOverEqual(valueArray, i)) {
                    hasOneAdjacent = true;
                    break;
                }
            } else if (i == (valueArray.length - 1)) {
                if (doesPreviousValueEqual(valueArray, i) && !doesTwoValuesPastEqual(valueArray, i)) {
                    hasOneAdjacent = true;
                    break;
                }
            } else if (i == 1) {
                if ((doesNextValueEqual(valueArray, i) && !doesTwoValuesOverEqual(valueArray, i))
                        && ((doesNextValueEqual(valueArray, i) && !doesPreviousValueEqual(valueArray, i))
                        || (doesPreviousValueEqual(valueArray, i) && !doesNextValueEqual(valueArray, i)))) {
                    hasOneAdjacent = true;
                    break;
                }
            } else if (i == (valueArray.length - 2)) {
                if ((doesPreviousValueEqual(valueArray, i) && !doesTwoValuesPastEqual(valueArray, i))
                        && ((doesNextValueEqual(valueArray, i) && !doesPreviousValueEqual(valueArray, i))
                        || (doesPreviousValueEqual(valueArray, i) && !doesNextValueEqual(valueArray, i)))) {
                    hasOneAdjacent = true;
                    break;
                }
            } else {
                if (((doesPreviousValueEqual(valueArray, i) && !doesTwoValuesPastEqual(valueArray, i))
                        && ((doesNextValueEqual(valueArray, i) && !doesPreviousValueEqual(valueArray, i))
                        || (doesPreviousValueEqual(valueArray, i) && !doesNextValueEqual(valueArray, i))))
                        || ((doesNextValueEqual(valueArray, i) && !doesTwoValuesOverEqual(valueArray, i))
                        && ((doesNextValueEqual(valueArray, i) && !doesPreviousValueEqual(valueArray, i))
                        || (doesPreviousValueEqual(valueArray, i) && !doesNextValueEqual(valueArray, i))))) {
                    hasOneAdjacent = true;
                    break;
                }
            }
        }

        return hasOneAdjacent;
    }

    private boolean neverDecreasingCheck(Integer value) {
        char[] valueArray = String.valueOf(value).toCharArray();
        boolean isNeverDecreasing = true;

        for (int i = 0; i < valueArray.length; i++) {
            for (int j = i; j < valueArray.length; j++) {
                if (valueArray[j] < valueArray[i]) {
                    isNeverDecreasing = false;
                }
            }
        }

        return isNeverDecreasing;
    }

    private boolean doesTwoValuesPastEqual(char[] valueArray, int i) {
        return valueArray[i] == valueArray[(i - 2)];
    }

    private boolean doesPreviousValueEqual(char[] valueArray, int i) {
        return valueArray[i] == valueArray[(i - 1)];
    }

    private boolean doesTwoValuesOverEqual(char[] valueArray, int i) {
        return valueArray[i] == valueArray[(i + 2)];
    }

    private boolean doesNextValueEqual(char[] valueArray, int i) {
        return valueArray[i] == valueArray[(i + 1)];
    }
}
