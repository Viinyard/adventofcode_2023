package com.adventofcode.soluce.day1;

import com.adventofcode.utils.FileReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

class Puzzle2 {

    /**
     * <p>--- Part Two ---</p>
     * <p>Your calculation isn't quite right. It looks like some of the digits are actually <b>spelled out with letters</b>: one, two, three, four, five, six, seven, eight, and nine <b>also</b> count as valid "digits".</p>
     * <p>Equipped with this new information, you now need to find the real first and last digit on each line. For example:</p>
     * <pre>
     * two1nine
     * eightwothree
     * abcone2threexyz
     * xtwone3four
     * 4nineeightseven2
     * zoneight234
     * 7pqrstsixteen
     * </pre>
     * <p>In this example, the calibration values are 29, 83, 13, 24, 42, 14, and 76. Adding these together produces <b>281</b>.</p>
     * <p><b>What is the sum of all of the calibration values?</b></p>
     * <p>Your puzzle answer was 53389.</p>
     */
    public static void main(String... args) throws IOException, URISyntaxException {
        List<String> lines = FileReader.readFileToList("day1/input.txt");

        Pattern positiveLookahead = Pattern.compile("(?=\\d|one|two|three|four|five|six|seven|eight|nine)");
        Pattern positiveLookbehind = Pattern.compile("(?<=\\d|one|two|three|four|five|six|seven|eight|nine)");

        BiFunction<String, Function<List<MatchResult>, MatchResult>, String> getMatch = (s, f) -> {
            MatchResult start = f.apply(positiveLookahead.matcher(s).results().toList());
            MatchResult end = f.apply(positiveLookbehind.matcher(s).results().toList());

            return s.substring(start.start(), end.end());
        };

        BiFunction<String, Function<List<MatchResult>, MatchResult>, String> getNumeralMatch = getMatch.andThen(s ->
                switch (s) {
                    case "one" -> "1";
                    case "two" -> "2";
                    case "three" -> "3";
                    case "four" -> "4";
                    case "five" -> "5";
                    case "six" -> "6";
                    case "seven" -> "7";
                    case "eight" -> "8";
                    case "nine" -> "9";
                    default -> s;
                }
        );

        int result = lines.stream().map(s -> {
            String first = getNumeralMatch.apply(s, List::getFirst);
            String last = getNumeralMatch.apply(s, List::getLast);

            return first + last;
        }).mapToInt(Integer::parseInt).sum();

        System.out.println(result);
    }
}
