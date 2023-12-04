package com.adventofcode.soluce.day4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PuzzleTest {

    private static Stream<Arguments> puzzle1() {
        return Stream.of(
                Arguments.of("day4/test/line1.txt", 8, null, null),
                Arguments.of("day4/test/line2.txt", 2, null, null),
                Arguments.of("day4/test/line3.txt", 2, null, null),
                Arguments.of("day4/test/line4.txt", 1, null, null),
                Arguments.of("day4/test/line5.txt", 0, null, null),
                Arguments.of("day4/test/line6.txt", 0, null, null),
                Arguments.of("day4/test/test.txt", 13, null, null),
                Arguments.of("day4/input.txt", 25174, null, null)
        );
    }

    @ParameterizedTest
    @MethodSource
    void puzzle1(String fileName, int expected, Class<? extends Exception> expectedException, String errorMsg) {
        try {
            int result = Puzzle1.solve(fileName);

            Assertions.assertThat(result).isEqualTo(expected);
        } catch (Exception e) {
            Assertions.assertThat(expectedException).withFailMessage(String.format("Unexpected exception has been thrown : %s", e)).isNotNull();
            Assertions.assertThat(e).isInstanceOf(expectedException).hasMessage(errorMsg);
        }
    }

    private static Stream<Arguments> puzzle2() {
        return Stream.of(
                Arguments.of("day4/test/line1.txt", 1, null, null),
                Arguments.of("day4/test/line2.txt", 1, null, null),
                Arguments.of("day4/test/line3.txt", 1, null, null),
                Arguments.of("day4/test/line4.txt", 1, null, null),
                Arguments.of("day4/test/line5.txt", 1, null, null),
                Arguments.of("day4/test/line6.txt", 1, null, null),
                Arguments.of("day4/test/test.txt", 30, null, null),
                Arguments.of("day4/input.txt", 6420979, null, null)
        );
    }

    @ParameterizedTest
    @MethodSource
    void puzzle2(String fileName, int expected, Class<? extends Exception> expectedException, String errorMsg) {
        try {
            int result = Puzzle2.solve(fileName);

            Assertions.assertThat(result).isEqualTo(expected);
        } catch (Exception e) {
            Assertions.assertThat(expectedException).withFailMessage(String.format("Unexpected exception has been thrown : %s", e)).isNotNull();
            Assertions.assertThat(e).isInstanceOf(expectedException).hasMessage(errorMsg);
        }
    }
}
