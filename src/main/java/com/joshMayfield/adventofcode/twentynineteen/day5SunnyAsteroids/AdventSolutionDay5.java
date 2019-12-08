package com.joshMayfield.adventofcode.twentynineteen.day5SunnyAsteroids;

import com.joshMayfield.adventofcode.AdventOfCodeFileUtils;
import com.joshMayfield.adventofcode.twentynineteen.day2ProgramAlarm.OpCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;

@Component
public class AdventSolutionDay5 {

    @Autowired
    private AdventOfCodeFileUtils fileUtils;

    @PostConstruct
    public void findSolution() {
        List<String> input = fileUtils.readFile("2019", this.getClass());
        solvePart1(input);
        //solvePart2();
    }

    private void solvePart1(List<String> input) {
        String intcodeInput = input.get(0);
        String[] intcodeArray = intcodeInput.split(",");
        String[] instructions = intcodeArray.clone();
        analyzeInput(instructions);
    }

    private void solvePart2() {
    }

    private void analyzeInput(String[] instructions) {
        for (int position = 0; position < instructions.length; ) {
            Integer opCodeVal = Integer.valueOf(instructions[position]);
            if (!opCodeVal.equals(99)) {
                OpCode opCode;

                if (opCodeVal.equals(3)) {
                    opCode = OpCodeFactory.buildOpCode(position, instructions, 5);
                } else {
                    opCode = OpCodeFactory.buildOpCode(position, instructions, null);
                }

                opCode.performOpCodeInstructions(position, instructions);

                if (Objects.nonNull(opCode.getNewAddress())) {
                    position = opCode.getNewAddress();
                } else {
                    position += opCode.getNumOfInstructions();
                }
            } else {
                break;
            }
        }
    }
}
