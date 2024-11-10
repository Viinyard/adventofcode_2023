package pro.vinyard.adventofcode.soluce.year2023.day8;

import org.junit.jupiter.params.provider.Arguments;
import pro.vinyard.adventofcode.api.Solution;
import pro.vinyard.adventofcode.common.BaseTest;

import java.util.stream.Stream;

public class Day8Part1SolutionTest extends BaseTest<Long> {

    @Override
    public Solution<Long> getSolution() {
        return new Day8Part1Solution();
    }

    @Override
    public Stream<Arguments> testSolution() {
        return Stream.of(
                Arguments.of("soluce/year2023/day8/part1/test1.txt", 2L, null, null),
                Arguments.of("soluce/year2023/day8/part1/test2.txt", 6L, null, null),
                Arguments.of("soluce/year2023/day8/input.txt", 17873L, null, null)
        );
    }
}
