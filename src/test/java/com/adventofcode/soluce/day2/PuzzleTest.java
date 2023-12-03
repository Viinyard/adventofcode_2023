package com.adventofcode.soluce.day2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PuzzleTest {

    private static Stream<Arguments> puzzle1() {
        return Stream.of(
                Arguments.of("day2/test/line1.txt", 1, null, null),
                Arguments.of("day2/test/line2.txt", 2, null, null),
                Arguments.of("day2/test/line3.txt", 0, null, null),
                Arguments.of("day2/test/line4.txt", 0, null, null),
                Arguments.of("day2/test/line5.txt", 5, null, null),
                Arguments.of("day2/test/test.txt", 8, null, null),
                Arguments.of("day2/input.txt", 2265, null, null)
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
                Arguments.of("day2/test/line1.txt", 48, null, null),
                Arguments.of("day2/test/line2.txt", 12, null, null),
                Arguments.of("day2/test/line3.txt", 1560, null, null),
                Arguments.of("day2/test/line4.txt", 630, null, null),
                Arguments.of("day2/test/line5.txt", 36, null, null),
                Arguments.of("day2/test/test.txt", 2286, null, null),
                Arguments.of("day2/input.txt", 64097, null, null)
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
