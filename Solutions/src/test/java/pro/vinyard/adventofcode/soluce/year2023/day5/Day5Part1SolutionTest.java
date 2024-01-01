package pro.vinyard.adventofcode.soluce.year2023.day5;

import org.junit.jupiter.params.provider.Arguments;
import pro.vinyard.adventofcode.common.BaseTest;
import pro.vinyard.adventofcode.core.Solution;

import java.util.stream.Stream;

public class Day5Part1SolutionTest extends BaseTest<Long> {

    @Override
    public Solution<Long> getSolution() {
        return new Day5Part1Solution();
    }

    @Override
    public Stream<Arguments> testSolution() {
        return Stream.of(
                Arguments.of("soluce/year2023/day5/part1/test.txt", 35L, null, null),
                Arguments.of("soluce/year2023/day5/input.txt", 600279879L, null, null)
        );
    }
}
