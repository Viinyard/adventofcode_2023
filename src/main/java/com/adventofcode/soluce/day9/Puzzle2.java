package com.adventofcode.soluce.day9;

import com.adventofcode.day9.grammar.Day9Lexer;
import com.adventofcode.day9.grammar.Day9Parser;
import com.adventofcode.utils.FileReader;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.net.URISyntaxException;

public class Puzzle2 {

    /**
     * <p>--- Part Two ---</p>
     * <p>Of course, it would be nice to have <b>even more history</b> included in your report. Surely it's safe to just <b>extrapolate backwards</b> as well, right?</p>
     * <p>For each history, repeat the process of finding differences until the sequence of differences is entirely zero. Then, rather than adding a zero to the end and filling in the next values of each previous sequence, you should instead add a zero to the <b>beginning</b> of your sequence of zeroes, then fill in new <b>first</b> values for each previous sequence.</p>
     * <p>In particular, here is what the third example history looks like when extrapolating back in time:</p>
     * <pre>
     * 5  10  13  16  21  30  45
     *   5   3   3   5   9  15
     *    -2   0   2   4   6
     *       2   2   2   2
     *         0   0   0
     * </pre>
     * <p>Adding the new values on the left side of each sequence from bottom to top eventually reveals the new left-most history value: <b>5</b>.</p>
     * <p>Doing this for the remaining example data above results in previous values of -3 for the first history and <b>0</b> for the second history. Adding all three new values together produces <b>2</b>.</p>
     * <p>Analyze your OASIS report again, this time extrapolating the previous value for each history. <b>What is the sum of these extrapolated values?</b></p>
     */
    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println(solve("day9/input.txt"));
    }

    static long solve(String fileName) throws IOException, URISyntaxException {
        String input = FileReader.readFileToString(fileName);

        CharStream charStream = CharStreams.fromString(input);

        Day9Lexer lexer = new Day9Lexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Day9Parser parser = new Day9Parser(tokens);
        ASD.Report report = parser.report().out;

        return report.getSuites().stream().mapToLong(ASD.Suite::getPreviousValue).sum();
    }
}
