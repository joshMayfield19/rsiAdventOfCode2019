package com.joshMayfield.adventofcode.twentynineteen.day5SunnyAsteroids;

import com.joshMayfield.adventofcode.twentynineteen.day2ProgramAlarm.OpCode;

public interface OpCodeAdapter {
    OpCode buildOpCode(String opCode, String[] instructions, Integer index, Integer userInput);
}
