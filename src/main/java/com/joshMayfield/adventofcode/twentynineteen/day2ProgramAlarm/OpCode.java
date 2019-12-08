package com.joshMayfield.adventofcode.twentynineteen.day2ProgramAlarm;

import com.joshMayfield.adventofcode.twentynineteen.day5SunnyAsteroids.ParameterNode;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OpCode {
    private Integer code;
    private Integer inputOneValue;
    private Integer inputTwoValue;
    private Integer inputThreeValue;
    private Integer userInput;
    private Integer numOfInstructions;
    private ParameterNode parameterNode;
    private Integer newAddress;

    public void performOpCodeInstructions(Integer position, String[] instructions) {
        if (getCode().equals(1) || getCode().equals(2)) {
            Integer outputLoc = Integer.valueOf(instructions[position + 3]);
            if (getCode().equals(1)) {
                instructions[outputLoc] = String.valueOf(Integer.valueOf(instructions[getInputOneValue()])
                        + Integer.valueOf(instructions[getInputTwoValue()]));
            } else {
                instructions[outputLoc] = String.valueOf(Integer.valueOf(instructions[getInputOneValue()])
                        * Integer.valueOf(instructions[getInputTwoValue()]));
            }
        } else if (getCode().equals(3)) {
            Integer outputLoc = Integer.valueOf(instructions[position + 1]);
            instructions[outputLoc] = String.valueOf(getUserInput());
        } else if (getCode().equals(4)) {
            Integer outputLoc = Integer.valueOf(instructions[position + 1]);
            System.out.println("Test Result: " + instructions[outputLoc]);
        } else if (getCode().equals(5)) {
            if (Integer.valueOf(instructions[getInputOneValue()]) != 0) {
                setNewAddress(Integer.valueOf(instructions[getInputTwoValue()]));
            }
        } else if (getCode().equals(6)) {
            if (Integer.valueOf(instructions[getInputOneValue()]).equals(0)) {
                setNewAddress(Integer.valueOf(instructions[getInputTwoValue()]));
            }
        } else if (getCode().equals(7)) {
            Integer firstVal = Integer.valueOf(instructions[getInputOneValue()]);
            Integer secondVal = Integer.valueOf(instructions[getInputTwoValue()]);
            Integer outputValue = (firstVal < secondVal) ? 1 : 0;
            instructions[getInputThreeValue()] = String.valueOf(outputValue);
        } else if (getCode().equals(8)) {
            Integer firstVal = Integer.valueOf(instructions[getInputOneValue()]);
            Integer secondVal = Integer.valueOf(instructions[getInputTwoValue()]);
            Integer outputValue = (firstVal.equals(secondVal)) ? 1 : 0;
            instructions[getInputThreeValue()] = String.valueOf(outputValue);
        } else {
            if (Objects.nonNull(getCode()) && Objects.nonNull(getParameterNode())) {
                ParameterNode parameterNode = getParameterNode();
                Integer firstParameterValue = null;
                Integer secondParameterValue = null;
                Integer thirdParameterValue = null;
                String stringCode = String.valueOf(getCode());
                String realCode = stringCode.substring(stringCode.length() - 2);

                if (Objects.nonNull(parameterNode.getFirstParameter())) {
                    if (parameterNode.getFirstMode().equals(0)) {
                        firstParameterValue = Integer.valueOf(instructions[parameterNode.getFirstParameter()]);
                    } else {
                        firstParameterValue = Integer.valueOf(instructions[position + 1]);
                    }
                }

                if (Objects.nonNull(parameterNode.getSecondParameter())) {
                    if (parameterNode.getSecondMode().equals(0)) {
                        secondParameterValue = Integer.valueOf(instructions[parameterNode.getSecondParameter()]);
                    } else {
                        secondParameterValue = Integer.valueOf(instructions[position + 2]);
                    }
                }

                thirdParameterValue = Integer.valueOf(instructions[position + 3]);

                if (realCode.equals("01")) {
                    if (Objects.nonNull(firstParameterValue) && Objects.nonNull(secondParameterValue)) {
                        Integer outputLoc = Integer.valueOf(instructions[position + 3]);
                        instructions[outputLoc] = String.valueOf(firstParameterValue + secondParameterValue);
                    }
                } else if (realCode.equals("02")) {
                    if (Objects.nonNull(secondParameterValue) && Objects.nonNull(secondParameterValue)) {
                        Integer outputLoc = Integer.valueOf(instructions[position + 3]);
                        instructions[outputLoc] = String.valueOf(firstParameterValue * secondParameterValue);
                    }
                } else if (realCode.equals("03")) {
                    Integer outputLoc = Integer.valueOf(instructions[position + 1]);
                    instructions[outputLoc] = String.valueOf(getUserInput());
                } else if (realCode.equals("04")) {
                    System.out.println("Test Result: " + firstParameterValue);
                } else if (realCode.equals("05")) {
                    if (!firstParameterValue.equals(0)) {
                        setNewAddress(secondParameterValue);
                    }
                } else if (realCode.equals("06")) {
                    if (firstParameterValue.equals(0)) {
                        setNewAddress(secondParameterValue);
                    }
                } else if (realCode.equals("07")) {
                    Integer outputValue = firstParameterValue < secondParameterValue ? 1 : 0;
                    instructions[thirdParameterValue] = String.valueOf(outputValue);
                } else if (realCode.equals("08")) {
                    Integer outputValue = firstParameterValue.equals(secondParameterValue) ? 1 : 0;
                    instructions[thirdParameterValue] = String.valueOf(outputValue);
                }
            }
        }
    }
}
