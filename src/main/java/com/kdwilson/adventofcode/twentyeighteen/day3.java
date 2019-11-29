package com.kdwilson.adventofcode.twentyeighteen;

import com.kdwilson.adventofcode.AdventOfCodeFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class day3 {

    @Autowired
    private AdventOfCodeFileUtils fileUtils;

    @PostConstruct
    public void solvePart1()
    {
        List<String> input = fileUtils.readFile("2018", this.getClass());



    }
}
