package se.jonte.adventofcode;


import com.google.common.io.Resources;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class DayOne {

    private static final Logger logger = LogManager.getLogger(DayOne.class);

    public static void main(String[] args) {
        logger.info("Started solving the Day 1 puzzle");
        final URL url = Resources.getResource("day-one-input.txt");
        List<String> massStrings = new LinkedList<>();
        try {
            massStrings = Resources.readLines(url, StandardCharsets.UTF_8);
        } catch (IOException e) {
            logger.fatal("Failed to read day 1 input file on path {}", url);
            System.exit(1);
        }

        List<Integer> masses = new LinkedList<>();
        parseMasses(massStrings, masses);

        int fuelSum = 0;
        for (int mass : masses)
            fuelSum += (mass / 3 - 2);
        logger.info("Calculated fuel sum for task 1 is {}", fuelSum);

        fuelSum = 0;
        for (int mass : masses) {
            int intermediateSum = (mass / 3 - 2);
            while (intermediateSum >= 0) {
                fuelSum += intermediateSum;
                intermediateSum = (intermediateSum / 3 - 2);
            }
        }
        logger.info("Calculated fuel sum for task 2 is {}", fuelSum);
        logger.info("Day 1 puzzle has been calculated");
        System.exit(0);
    }

    private static void parseMasses(List<String> massStrings, List<Integer> masses) {
        for (String s : massStrings)
            masses.add(Integer.parseInt(s));
    }

}
