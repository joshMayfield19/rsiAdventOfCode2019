package com.joshMayfield.adventofcode.twentynineteen.day3CrossedWires;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.joshMayfield.adventofcode.AdventOfCodeFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class AdventSolutionDay3 {
    private static List<PanelWire> panelWires;
    private static Multimap<Integer, Integer> intersections;

    @Autowired
    private AdventOfCodeFileUtils fileUtils;

    //@PostConstruct
    public void findSolution() {
        List<String> input = fileUtils.readFile("2019", this.getClass());
        panelWires = new ArrayList<>();
        intersections = ArrayListMultimap.create();

        solvePart1(input);
        solvePart2();
    }

    private void solvePart1(List<String> input) {
        for (String line : input) {
            String[] coordinates = line.split(",");
            PanelWire panelWire = new PanelWire();

            int counter = 1;

            for (String coordinate : coordinates) {
                String direction = String.valueOf(coordinate.charAt(0));
                Integer move = Integer.valueOf(coordinate.substring(1));
                panelWire.addCoordinates(direction, move);
                counter++;
            }

            panelWires.add(panelWire);
        }

        findManhattanDistance(panelWires);
    }

    private void solvePart2() {
        List<String> xY = new ArrayList<>();

        for (Integer xCoord : intersections.keySet()) {
            for (Integer yCoord : intersections.get(xCoord)) {
                xY.add(xCoord + "," + yCoord);
            }
        }

        List<WireStep> intersectionSteps = new ArrayList<>();
        List<Integer> stepsList = new ArrayList<>();

        for (String intersectionCoordinates : xY) {
            String[] coords = intersectionCoordinates.split(",");
            for (PanelWire panelWire : panelWires) {
                for (WireStep wireStep : panelWire.getWireStepList()) {
                    if (Integer.valueOf(wireStep.getX()).equals(Integer.valueOf(coords[0])) &&
                            Integer.valueOf(wireStep.getY()).equals(Integer.valueOf(coords[1]))) {
                        intersectionSteps.add(wireStep);
                        break;
                    } else {
                        intersectionSteps.add(wireStep);
                    }
                }
            }

            stepsList.add(intersectionSteps.size());
            intersectionSteps = new ArrayList<>();
        }

        Collections.sort(stepsList);

        System.out.println("Minimum Steps: " + stepsList.get(0));
    }

    private void findManhattanDistance(List<PanelWire> panelWires) {
        Multimap<Integer, Integer> panelWire1Coords = panelWires.get(0).getCoordinates();
        Multimap<Integer, Integer> panelWire2Coords = panelWires.get(1).getCoordinates();

        List<Integer> distances = new ArrayList<>();

        intersections = Multimaps.filterEntries(panelWire1Coords, e ->
                panelWire2Coords.containsEntry(e.getKey(), e.getValue()));

        for (Integer xCoord : intersections.keySet()) {
            for (Integer yCoord : intersections.get(xCoord)) {
                int distance = Math.abs(xCoord) + Math.abs(yCoord);
                distances.add(distance);
            }
        }

        Collections.sort(distances);

        System.out.println("Manhattan Distance: " + distances.get(0));
    }
}
