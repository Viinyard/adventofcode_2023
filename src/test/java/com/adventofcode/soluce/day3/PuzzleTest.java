package com.adventofcode.soluce.day3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PuzzleTest {

    private static Stream<Arguments> puzzle1() {
        return Stream.of(
                Arguments.of("day3/test/test.txt", 4361, null, null),
                Arguments.of("day3/input.txt", 535235, null, null)
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
                Arguments.of("day3/test/test.txt", 467835, null, null),
                Arguments.of("day3/input.txt", 79844424, null, null)
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
