package pro.vinyard.adventofcode.plugins.core;

import pro.vinyard.adventofcode.core.annotation.AdventOfCodeSolution;

public class InputRetriever {

    public static String retrieve(AdventOfCodeSolution solution) {
        return String.format("soluce/year%d/day%d/input.txt", solution.year(), solution.day());
    }
}
