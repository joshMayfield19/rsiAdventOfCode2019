package com.kdwilson.adventofcode;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class AdventOfCodeFileUtils {

    public List<String> readFile(String yearName, Class className) {
        Path path = null;
        String solutionName = yearName + className.getSimpleName();
        try {
            path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                    .getResource(solutionName)).toURI());
        } catch (URISyntaxException e) {
            log.error("Path not found for problem: '{}'", solutionName);
            log.error("Stack trace: ", e);
        }

        List<String> output = new ArrayList<>();
        Stream<String> lines = null;
        try {
            lines = Files.lines(path);
            lines.forEach(output::add);
        } catch (IOException e) {
            log.error("Problem reading file lines for problem: '{}'", solutionName);
            log.error("Stack trace: ", e);
        } finally {
            lines.close();
        }

        log.info("Output for problem: '{}' is : '{}'", solutionName, output);
        return output;

    }
}
