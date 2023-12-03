package com.adventofcode.soluce.day1;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PuzzleTest {

    private static Stream<Arguments>  puzzle1() {
        return Stream.of(
                Arguments.of("day1/test1/line1.txt", 12, null, null),
                Arguments.of("day1/test1/line2.txt", 38, null, null),
                Arguments.of("day1/test1/line3.txt", 15, null, null),
                Arguments.of("day1/test1/line4.txt", 77, null, null),
                Arguments.of("day1/test1/test.txt", 142, null, null),
                Arguments.of("day1/input.txt", 54338, null, null)
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

    private static Stream<Arguments>  puzzle2() {
        return Stream.of(
                Arguments.of("day1/test2/line1.txt", 29, null, null),
                Arguments.of("day1/test2/line2.txt", 83, null, null),
                Arguments.of("day1/test2/line3.txt", 13, null, null),
                Arguments.of("day1/test2/line4.txt", 24, null, null),
                Arguments.of("day1/test2/line5.txt", 42, null, null),
                Arguments.of("day1/test2/line6.txt", 14, null, null),
                Arguments.of("day1/test2/line7.txt", 76, null, null),
                Arguments.of("day1/test2/test.txt", 281, null, null),
                Arguments.of("day1/input.txt", 53389, null, null)
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
