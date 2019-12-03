package com.joshMayfield.adventofcode.twentynineteen.day3CrossedWires;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class PanelWire {
    private Multimap<Integer, Integer> coordinates;
    private List<WireStep> wireStepList;
    private Integer lastXCoordinate;
    private Integer lastYCoordinate;

    public PanelWire() {
        this.coordinates = ArrayListMultimap.create();
        this.lastYCoordinate = 0;
        this.lastXCoordinate = 0;
        this.wireStepList = new ArrayList<>();
    }

    public void addCoordinates(String direction, Integer move) {
        int nextStep = 1;

        if (!CollectionUtils.isEmpty(wireStepList)) {
            int lastStep = wireStepList.size();
            nextStep = wireStepList.get(lastStep-1).getStep();
        }

        if ("R".equalsIgnoreCase(direction)) {
            int xVal = this.lastXCoordinate + 1;
            int end = this.lastXCoordinate + move;
            for (int i = xVal; i <= end; i++) {
                this.coordinates.put(i, this.lastYCoordinate);

                wireStepList.add(WireStep.builder()
                        .x(i)
                        .y(this.lastYCoordinate)
                        .step(nextStep)
                        .build());

                this.lastXCoordinate = end;
            }
        } else if ("U".equalsIgnoreCase(direction)) {
            int yVal = this.lastYCoordinate + 1;
            int end = this.lastYCoordinate + move;
            for (int i = yVal; i <= end; i++) {
                this.coordinates.put(this.lastXCoordinate, i);

                wireStepList.add(WireStep.builder()
                        .x(this.lastXCoordinate)
                        .y(i)
                        .step(nextStep)
                        .build());

                this.lastYCoordinate = end;
            }
        } else if ("L".equalsIgnoreCase(direction)) {
            int xVal = this.lastXCoordinate - 1;
            int end = this.lastXCoordinate - move;
            for (int i = xVal; i >= end; i--) {
                this.coordinates.put(i, this.lastYCoordinate);

                wireStepList.add(WireStep.builder()
                        .x(i)
                        .y(this.lastYCoordinate)
                        .step(nextStep)
                        .build());

                this.lastXCoordinate = end;
            }
        } else {
            int yVal = this.lastYCoordinate - 1;
            int end = this.lastYCoordinate - move;
            for (int i = yVal; i >= end; i--) {
                this.coordinates.put(this.lastXCoordinate, i);

                wireStepList.add(WireStep.builder()
                        .x(this.lastXCoordinate)
                        .y(i)
                        .step(nextStep)
                        .build());

                this.lastYCoordinate = end;
            }
        }
    }
}
