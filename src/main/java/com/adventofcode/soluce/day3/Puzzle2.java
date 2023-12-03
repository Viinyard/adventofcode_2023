package com.adventofcode.soluce.day3;

import com.adventofcode.day3.grammar.Day3Lexer;
import com.adventofcode.day3.grammar.Day3Parser;
import com.adventofcode.utils.FileReader;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

public class Puzzle2 {

    /**
     * <p>--- Part Two ---</p>
     * <p>The engineer finds the missing part and installs it in the engine! As the engine springs to life, you jump in the closest gondola, finally ready to ascend to the water source.</p>
     * <p>You don't seem to be going very fast, though. Maybe something is still wrong? Fortunately, the gondola has a phone labeled "help", so you pick it up and the engineer answers.</p>
     * <p>Before you can explain the situation, she suggests that you look out the window. There stands the engineer, holding a phone in one hand and waving with the other. You're going so slowly that you haven't even left the station. You exit the gondola.</p>
     * <p>The missing part wasn't the only issue - one of the gears in the engine is wrong. A <b>gear</b> is any * symbol that is adjacent to <b>exactly two part numbers</b>. Its <b>gear ratio</b> is the result of multiplying those two numbers together.</p>
     * <p>This time, you need to find the gear ratio of every gear and add them all up so that the engineer can figure out which gear needs to be replaced.</p>
     * <p>Consider the same engine schematic again:</p>
     * <pre>
     * 467..114..
     * ...*......
     * ..35..633.
     * ......#...
     * 617*......
     * .....+.58.
     * ..592.....
     * ......755.
     * ...$.*....
     * .664.598..
     * </pre>
     * <p>In this schematic, there are <b>two</b> gears. The first is in the top left; it has part numbers 467 and 35, so its gear ratio is 16345. The second gear is in the lower right; its gear ratio is 451490. (The * adjacent to 617 is <b>not</b> a gear because it is only adjacent to one part number.) Adding up all of the gear ratios produces <b>467835</b>.</p>
     * <p><b>What is the sum of all of the gear ratios in your engine schematic?</b></p>
     */
    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println(solve("day3/input.txt"));
    }

    static int solve(String fileName) throws IOException, URISyntaxException {
        String input = FileReader.readFileToString(fileName);

        CharStream charStream = CharStreams.fromString(input);

        Day3Lexer lexer = new Day3Lexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Day3Parser parser = new Day3Parser(tokens);
        ASD.Engine engine = parser.engine().out;

        List<ASD.Number> numbers = engine.getParts().stream().filter(ASD.Number.class::isInstance).map(ASD.Number.class::cast).toList();

        List<ASD.Gear> gears = engine.getParts().stream().filter(ASD.Gear.class::isInstance).map(ASD.Gear.class::cast).toList();

        return gears.stream().map(g ->
                numbers.stream().filter(n -> n.getRectangle().intersects(g.getSize())).map(ASD.Number::getValue).map(Integer::parseInt).collect(Collectors.toList())
        ).filter(l -> l.size() == 2).mapToInt(l -> l.stream().reduce(1, (a, b) -> a * b)).sum();
    }
}
