package com.adventofcode.soluce.day7;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PuzzleTest {

    private static Stream<Arguments> puzzle1() {
        return Stream.of(
                Arguments.of("day7/test/line1.txt", 765, null, null),
                Arguments.of("day7/test/line2.txt", 684, null, null),
                Arguments.of("day7/test/line3.txt", 28, null, null),
                Arguments.of("day7/test/line4.txt", 220, null, null),
                Arguments.of("day7/test/line5.txt", 483, null, null),
                Arguments.of("day7/test/test.txt", 6440, null, null),
                Arguments.of("day7/input.txt", 248453531, null, null)
        );
    }

    private static Stream<Arguments> puzzle2() {
        return Stream.of(
                Arguments.of("day7/test/line1.txt", 765, null, null),
                Arguments.of("day7/test/line2.txt", 684, null, null),
                Arguments.of("day7/test/line3.txt", 28, null, null),
                Arguments.of("day7/test/line4.txt", 220, null, null),
                Arguments.of("day7/test/line5.txt", 483, null, null),
                Arguments.of("day7/test/test.txt", 5905, null, null),
                Arguments.of("day7/input.txt", 248781813, null, null)
        );
    }

    @ParameterizedTest
    @MethodSource
    void puzzle1(String fileName, long expected, Class<? extends Exception> expectedException, String errorMsg) {
        try {
            long result = Puzzle1.solve(fileName);

            Assertions.assertThat(result).isEqualTo(expected);
        } catch (Exception e) {
            Assertions.assertThat(expectedException).withFailMessage(String.format("Unexpected exception has been thrown : %s", e)).isNotNull();
            Assertions.assertThat(e).isInstanceOf(expectedException).hasMessage(errorMsg);
        }
    }

    @ParameterizedTest
    @MethodSource
    void puzzle2(String fileName, long expected, Class<? extends Exception> expectedException, String errorMsg) {
        try {
            long result = Puzzle2.solve(fileName);

            Assertions.assertThat(result).isEqualTo(expected);
        } catch (Exception e) {
            Assertions.assertThat(expectedException).withFailMessage(String.format("Unexpected exception has been thrown : %s", e)).isNotNull();
            Assertions.assertThat(e).isInstanceOf(expectedException).hasMessage(errorMsg);
        }
    }
}
