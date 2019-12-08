package com.joshMayfield.adventofcode.twentynineteen.day5SunnyAsteroids;

import com.joshMayfield.adventofcode.twentynineteen.day2ProgramAlarm.OpCode;

public class OpCodeParameterizedAdapter implements OpCodeAdapter {

    @Override
    public OpCode buildOpCode(String opCode, String[] instructions, Integer index, Integer userInput) {
        OpCode returnCode = new OpCode();
        returnCode.setCode(Integer.valueOf(opCode));
        String realCode = opCode.substring(opCode.length() - 2);

        Integer firstMode;
        Integer secondMode;
        Integer thirdMode;

        if (opCode.length() == 5) {
            firstMode = Integer.valueOf(opCode.substring(2, 3));
            secondMode = Integer.valueOf(opCode.substring(1, 2));
            thirdMode = Integer.valueOf(opCode.substring(0, 1));
        } else if (opCode.length() == 4) {
            firstMode = Integer.valueOf(opCode.substring(1, 2));
            secondMode = Integer.valueOf(opCode.substring(0, 1));
            thirdMode = 0;
        } else {
            firstMode = Integer.valueOf(opCode.substring(0, 1));
            secondMode = 0;
            thirdMode = 0;
        }

        if (realCode.equals("01") || realCode.equals("02")) {
            returnCode.setParameterNode(ParameterNode.builder()
                    .firstParameter(Integer.valueOf(instructions[index + 1]))
                    .firstMode(firstMode)
                    .secondParameter(Integer.valueOf(instructions[index + 2]))
                    .secondMode(secondMode)
                    .thirdParameter(Integer.valueOf(instructions[index + 3]))
                    .thirdMode(thirdMode)
                    .build());
            returnCode.setNumOfInstructions(4);
            return returnCode;
        } else if (realCode.equals("03")) {
            returnCode.setUserInput(userInput);
            returnCode.setParameterNode(ParameterNode.builder()
                    .firstParameter(Integer.valueOf(instructions[index + 1]))
                    .firstMode(firstMode)
                    .build());
            returnCode.setNumOfInstructions(2);
            return returnCode;
        } else if (realCode.equals("04")) {
            returnCode.setParameterNode(ParameterNode.builder()
                    .firstParameter(Integer.valueOf(instructions[index + 1]))
                    .firstMode(firstMode)
                    .build());
            returnCode.setNumOfInstructions(2);
            return returnCode;
        } else if (realCode.equals("05") || realCode.equals("06")) {
            returnCode.setParameterNode(ParameterNode.builder()
                    .firstParameter(Integer.valueOf(instructions[index + 1]))
                    .firstMode(firstMode)
                    .secondParameter(Integer.valueOf(instructions[index + 2]))
                    .secondMode(secondMode)
                    .build());
            returnCode.setNumOfInstructions(3);

            return returnCode;
        } else if (realCode.equals("07") || realCode.equals("08")) {
            returnCode.setParameterNode(ParameterNode.builder()
                    .firstParameter(Integer.valueOf(instructions[index + 1]))
                    .firstMode(firstMode)
                    .secondParameter(Integer.valueOf(instructions[index + 2]))
                    .secondMode(secondMode)
                    .thirdParameter(Integer.valueOf(instructions[index + 3]))
                    .thirdMode(thirdMode)
                    .build());
            returnCode.setNumOfInstructions(4);

            return returnCode;
        } else {
            return OpCode.builder().build();
        }
    }
}
