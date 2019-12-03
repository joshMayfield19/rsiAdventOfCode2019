package com.joshMayfield.adventofcode.twentynineteen.day21202ProgramAlarm;

import com.joshMayfield.adventofcode.AdventOfCodeFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
public class AdventSolutionDay2 {
    private static int GRAVITY = 19690720;

    @Autowired
    private AdventOfCodeFileUtils fileUtils;

    //@PostConstruct
    public void findSolution() {
        List<String> input = fileUtils.readFile("2019", this.getClass());
        solvePart1(input);
        solvePart2(input);
    }

    private void solvePart1(List<String> input) {
        String intcodeInput = input.get(0);
        String[] intcodeArray = intcodeInput.split(",");
        String[] finalizedIntcodeArray = intcodeArray.clone();

        analyzeInput(finalizedIntcodeArray);

        System.out.println(Arrays.toString(finalizedIntcodeArray));
    }

    private void solvePart2(List<String> input) {
        String intcodeInput = input.get(0);
        String[] intcodeArray = intcodeInput.split(",");

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                String[] finalizedIntcodeArray = intcodeArray.clone();

                finalizedIntcodeArray[1] = String.valueOf(i);
                finalizedIntcodeArray[2] = String.valueOf(j);
                analyzeInput(finalizedIntcodeArray);

                if (Integer.valueOf(finalizedIntcodeArray[0]) == GRAVITY) {
                    System.out.println("Noun: " + i + "\nVerb: " + j);
                    break;
                }
            }
        }
    }

    private void analyzeInput(String[] finalizedIntcodeArray) {
        Integer index = 0;

        for (int i = 0; i < finalizedIntcodeArray.length; ) {
            if (!Integer.valueOf(finalizedIntcodeArray[index]).equals(99)) {
                findNextOpCode(index, finalizedIntcodeArray);
                index += 4;
            } else {
                break;
            }
        }
    }

    private void findNextOpCode(Integer index, String[] finalizedIntCodeArray) {
        String opCode = finalizedIntCodeArray[index];

        if (opCode.equals("1") || opCode.equals("2")) {
            Integer outputLoc = Integer.valueOf(finalizedIntCodeArray[index + 3]);

            OpCode code = OpCode.builder()
                    .code(Integer.valueOf(opCode))
                    .inputOneValue(Integer.valueOf(finalizedIntCodeArray[Integer.valueOf(finalizedIntCodeArray[index + 1])]))
                    .inputTwoValue(Integer.valueOf(finalizedIntCodeArray[Integer.valueOf(finalizedIntCodeArray[index + 2])]))
                    .build();

            if (opCode.equals("1")) {
                finalizedIntCodeArray[outputLoc] = String.valueOf(code.getInputOneValue() + code.getInputTwoValue());
            } else {
                finalizedIntCodeArray[outputLoc] = String.valueOf(code.getInputOneValue() * code.getInputTwoValue());
            }
        }
    }
}
