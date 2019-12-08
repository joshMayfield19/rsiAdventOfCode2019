package com.joshMayfield.adventofcode.twentynineteen.day5SunnyAsteroids;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ParameterNode {
    private Integer firstParameter;
    private Integer firstMode;
    private Integer secondParameter;
    private Integer secondMode;
    private Integer thirdParameter;
    private Integer thirdMode;
}
