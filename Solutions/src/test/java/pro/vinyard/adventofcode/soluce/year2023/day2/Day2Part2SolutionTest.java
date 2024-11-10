package pro.vinyard.adventofcode.soluce.year2023.day2;

import org.junit.jupiter.params.provider.Arguments;
import pro.vinyard.adventofcode.api.Solution;
import pro.vinyard.adventofcode.common.BaseTest;

import java.util.stream.Stream;

public class Day2Part2SolutionTest extends BaseTest<Long> {

    @Override
    public Solution<Long> getSolution() {
        return new Day2Part2Solution();
    }

    @Override
    public Stream<Arguments> testSolution() {
        return Stream.of(
                Arguments.of("soluce/year2023/day2/part2/line1.txt", 48L, null, null),
                Arguments.of("soluce/year2023/day2/part2/line2.txt", 12L, null, null),
                Arguments.of("soluce/year2023/day2/part2/line3.txt", 1560L, null, null),
                Arguments.of("soluce/year2023/day2/part2/line4.txt", 630L, null, null),
                Arguments.of("soluce/year2023/day2/part2/line5.txt", 36L, null, null),
                Arguments.of("soluce/year2023/day2/part2/test.txt", 2286L, null, null),
                Arguments.of("soluce/year2023/day2/input.txt", 64097L, null, null)
        );
    }
}
