package com.adventofcode.soluce.day6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PuzzleTest {

    private static Stream<Arguments> puzzle1() {
        return Stream.of(
                Arguments.of("day6/test/line1.txt", 4, null, null),
                Arguments.of("day6/test/line2.txt", 8, null, null),
                Arguments.of("day6/test/line3.txt", 9, null, null),
                Arguments.of("day6/test/test.txt", 288, null, null),
                Arguments.of("day6/input.txt", 840336, null, null)
        );
    }

    private static Stream<Arguments> puzzle2() {
        return Stream.of(
                Arguments.of("day6/test/line1.txt", 4, null, null),
                Arguments.of("day6/test/line2.txt", 8, null, null),
                Arguments.of("day6/test/line3.txt", 9, null, null),
                Arguments.of("day6/test/test.txt", 71503, null, null),
                Arguments.of("day6/input.txt", 41382569, null, null)
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
