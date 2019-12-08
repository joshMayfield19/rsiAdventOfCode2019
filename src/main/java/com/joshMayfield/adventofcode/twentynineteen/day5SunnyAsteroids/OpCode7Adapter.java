package com.joshMayfield.adventofcode.twentynineteen.day5SunnyAsteroids;

import com.joshMayfield.adventofcode.twentynineteen.day2ProgramAlarm.OpCode;

public class OpCode7Adapter implements OpCodeAdapter {

    @Override
    public OpCode buildOpCode(String opCode, String[] instructions, Integer index, Integer userInput) {
        return OpCode.builder()
                .code(Integer.valueOf(opCode))
                .inputOneValue(Integer.valueOf(instructions[index + 1]))
                .inputTwoValue(Integer.valueOf(instructions[index + 2]))
                .inputThreeValue(Integer.valueOf(instructions[index + 3]))
                .numOfInstructions(4)
                .build();
    }
}
