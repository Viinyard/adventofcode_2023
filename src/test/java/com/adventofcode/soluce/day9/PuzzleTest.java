package com.adventofcode.soluce.day9;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PuzzleTest {

    private static Stream<Arguments> puzzle1() {
        return Stream.of(
                Arguments.of("day9/test/line1.txt", 18, null, null),
                Arguments.of("day9/test/line2.txt", 28, null, null),
                Arguments.of("day9/test/line3.txt", 68, null, null),
                Arguments.of("day9/test/test.txt", 114, null, null),
                Arguments.of("day9/input.txt", 1904165718, null, null)
        );
    }

    private static Stream<Arguments> puzzle2() {
        return Stream.of(
                Arguments.of("day9/test/line1.txt", -3, null, null),
                Arguments.of("day9/test/line2.txt", 0, null, null),
                Arguments.of("day9/test/line3.txt", 5, null, null),
                Arguments.of("day9/test/test.txt", 2, null, null),
                Arguments.of("day9/input.txt", 964, null, null)
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
