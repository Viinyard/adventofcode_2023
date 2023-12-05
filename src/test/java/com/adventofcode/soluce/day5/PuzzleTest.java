package com.adventofcode.soluce.day5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PuzzleTest {

    private static Stream<Arguments> puzzle1() {
        return Stream.of(
                Arguments.of("day5/test/test.txt", 35, null, null),
                Arguments.of("day5/input.txt", 600279879, null, null)
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
}
