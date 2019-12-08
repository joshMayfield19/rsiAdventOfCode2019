package com.joshMayfield.adventofcode.twentynineteen.day5SunnyAsteroids;

import com.joshMayfield.adventofcode.twentynineteen.day2ProgramAlarm.OpCode;

public class OpCodeFactory {

    public static OpCode buildOpCode(Integer position, String[] instructions, Integer userInput) {
        String inputCode = instructions[position];

        switch (inputCode) {
            case "1":
                OpCode1Adapter opCode1Adapter = new OpCode1Adapter();
                return opCode1Adapter.buildOpCode(inputCode, instructions, position, null);
            case "2":
                OpCode2Adapter opCode2Adapter = new OpCode2Adapter();
                return opCode2Adapter.buildOpCode(inputCode, instructions, position, null);
            case "3":
                OpCode3Adapter opCode3Adapter = new OpCode3Adapter();
                return opCode3Adapter.buildOpCode(inputCode, instructions, position, userInput);
            case "4":
                OpCode4Adapter opCode4Adapter = new OpCode4Adapter();
                return opCode4Adapter.buildOpCode(inputCode, instructions, position, null);
            case "5":
                OpCode5Adapter opCode5Adapter = new OpCode5Adapter();
                return opCode5Adapter.buildOpCode(inputCode, instructions, position, null);
            case "6":
                OpCode6Adapter opCode6Adapter = new OpCode6Adapter();
                return opCode6Adapter.buildOpCode(inputCode, instructions, position, null);
            case "7":
                OpCode7Adapter opCode7Adapter = new OpCode7Adapter();
                return opCode7Adapter.buildOpCode(inputCode, instructions, position, null);
            case "8":
                OpCode8Adapter opCode8Adapter = new OpCode8Adapter();
                return opCode8Adapter.buildOpCode(inputCode, instructions, position, null);
            case "99":
                OpCode99Adapter opCode99Adapter = new OpCode99Adapter();
                return opCode99Adapter.buildOpCode(inputCode, instructions, position, null);
            default:
                OpCodeParameterizedAdapter opCodeParameterizedAdapter = new OpCodeParameterizedAdapter();
                return opCodeParameterizedAdapter.buildOpCode(inputCode, instructions, position, null);
        }
    }
}
