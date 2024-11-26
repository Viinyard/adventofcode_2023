package dev.vinyard.adventofcode.soluce.year2023.day3;

import dev.vinyard.adventofcode.common.BaseTest;
import dev.vinyard.aoc.plugins.solution.api.Solution;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class Day3Part2SolutionTest extends BaseTest<Long> {

    @Override
    public Solution<Long> getSolution() {
        return new Day3Part2Solution();
    }

    @Override
    public Stream<Arguments> testSolution() {
        return Stream.of(
                Arguments.of("soluce/year2023/day3/part2/test.txt", 467835L, null, null),
                Arguments.of("soluce/year2023/day3/input.txt", 79844424L, null, null)
        );
    }
}
