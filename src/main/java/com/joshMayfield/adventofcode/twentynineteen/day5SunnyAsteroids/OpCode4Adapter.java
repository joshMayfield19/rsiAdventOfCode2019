package com.joshMayfield.adventofcode.twentynineteen.day5SunnyAsteroids;

import com.joshMayfield.adventofcode.twentynineteen.day2ProgramAlarm.OpCode;

public class OpCode4Adapter implements OpCodeAdapter {

    @Override
    public OpCode buildOpCode(String opCode, String[] instructions, Integer index, Integer userInput) {
        return OpCode.builder()
                .code(Integer.valueOf(opCode))
                .inputOneValue(Integer.valueOf(instructions[index + 1]))
                .numOfInstructions(2)
                .build();
    }
}
