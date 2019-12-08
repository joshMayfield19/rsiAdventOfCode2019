package com.joshMayfield.adventofcode.twentynineteen.day5SunnyAsteroids;

import com.joshMayfield.adventofcode.twentynineteen.day2ProgramAlarm.OpCode;

public class OpCode5Adapter implements OpCodeAdapter {

    @Override
    public OpCode buildOpCode(String opCode, String[] instructions, Integer index, Integer userInput) {
        Integer newAddress = null;

        if (Integer.valueOf(instructions[index + 1]) != 0) {
            newAddress = Integer.valueOf(instructions[index + 2]);
        }

        return OpCode.builder()
                .code(Integer.valueOf(opCode))
                .inputOneValue(Integer.valueOf(instructions[index + 1]))
                .inputTwoValue(Integer.valueOf(instructions[index + 2]))
                .numOfInstructions(3)
                .newAddress(newAddress)
                .build();
    }
}
