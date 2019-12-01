package com.joshMayfield.adventofcode;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Component
public class AdventOfCodeFileUtils {

    public List<String> readFile(String yearName, Class className) {
        Path path = null;
        String solutionName = yearName + className.getSimpleName();
        try {
            path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                    .getResource(solutionName)).toURI());
        } catch (URISyntaxException e) {
            System.out.println("Path not found for problem: '" + solutionName + "'");
            System.out.println("Stack trace: +" + e);
        }

        List<String> output = new ArrayList<>();
        Stream<String> lines = null;
        try {
            lines = Files.lines(path);
            lines.forEach(output::add);
        } catch (IOException e) {
            System.out.println("Problem reading file lines for problem: '" + solutionName + "'");
            System.out.println("Stack trace: +" + e);
        } finally {
            lines.close();
        }

        return output;
    }
}
