package pro.vinyard.adventofcode.soluce.year2023.day3;

import org.junit.jupiter.params.provider.Arguments;
import pro.vinyard.adventofcode.common.BaseTest;
import pro.vinyard.adventofcode.core.Solution;

import java.util.stream.Stream;

public class Day3Part1SolutionTest extends BaseTest<Long> {

    @Override
    public Solution<Long> getSolution() {
        return new Day3Part1Solution();
    }

    @Override
    public Stream<Arguments> testSolution() {
        return Stream.of(
                Arguments.of("soluce/year2023/day3/part1/test.txt", 4361L, null, null),
                Arguments.of("soluce/year2023/day3/input.txt", 535235L, null, null)
        );
    }
}
