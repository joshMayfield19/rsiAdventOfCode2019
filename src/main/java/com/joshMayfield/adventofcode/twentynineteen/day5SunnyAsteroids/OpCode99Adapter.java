package com.joshMayfield.adventofcode.twentynineteen.day5SunnyAsteroids;

import com.joshMayfield.adventofcode.twentynineteen.day2ProgramAlarm.OpCode;

public class OpCode99Adapter implements OpCodeAdapter {

    @Override
    public OpCode buildOpCode(String opCode, String[] instructions, Integer index, Integer userInput) {
        return OpCode.builder().build();
    }
}
