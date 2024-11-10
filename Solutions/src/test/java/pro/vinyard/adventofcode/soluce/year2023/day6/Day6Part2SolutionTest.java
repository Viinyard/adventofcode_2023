package pro.vinyard.adventofcode.soluce.year2023.day6;

import org.junit.jupiter.params.provider.Arguments;
import pro.vinyard.adventofcode.api.Solution;
import pro.vinyard.adventofcode.common.BaseTest;

import java.util.stream.Stream;

public class Day6Part2SolutionTest extends BaseTest<Long> {

    @Override
    public Solution<Long> getSolution() {
        return new Day6Part2Solution();
    }

    @Override
    public Stream<Arguments> testSolution() {
        return Stream.of(
                Arguments.of("soluce/year2023/day6/part2/line1.txt", 4L, null, null),
                Arguments.of("soluce/year2023/day6/part2/line2.txt", 8L, null, null),
                Arguments.of("soluce/year2023/day6/part2/line3.txt", 9L, null, null),
                Arguments.of("soluce/year2023/day6/part2/test.txt", 71503L, null, null),
                Arguments.of("soluce/year2023/day6/input.txt", 41382569L, null, null)
        );
    }
}
