package pro.vinyard.adventofcode.soluce.year2023.day5;

import org.junit.jupiter.params.provider.Arguments;
import pro.vinyard.adventofcode.api.Solution;
import pro.vinyard.adventofcode.common.BaseTest;

import java.util.stream.Stream;

public class Day5Part2SolutionTest extends BaseTest<Long> {

    @Override
    public Solution<Long> getSolution() {
        return new Day5Part2Solution();
    }

    @Override
    public Stream<Arguments> testSolution() {
        return Stream.of(
                Arguments.of("soluce/year2023/day5/part2/test.txt", 46L, null, null),
                Arguments.of("soluce/year2023/day5/input.txt", 20191102L, null, null)
        );
    }
}
