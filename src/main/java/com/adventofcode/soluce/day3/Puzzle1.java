package com.adventofcode.soluce.day3;

import com.adventofcode.utils.FileReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Puzzle1 {

    /**
     * <p>You and the Elf eventually reach a <a href="https://en.wikipedia.org/wiki/Gondola_lift">gondola lift</a> station; he says the gondola lift will take you up to the <b>water source</b>, but this is as far as he can bring you. You go inside.</p>
     * <p>It doesn't take long to find the gondolas, but there seems to be a problem: they're not moving.</p>
     * <p>"Aaah!"</p>
     * <p>You turn around to see a slightly-greasy Elf with a wrench and a look of surprise. "Sorry, I wasn't expecting anyone! The gondola lift isn't working right now; it'll still be a while before I can fix it." You offer to help.</p>
     * <p>The engineer explains that an engine part seems to be missing from the engine, but nobody can figure out which one. If you can <b>add up all the part numbers</b> in the engine schematic, it should be easy to work out which part is missing.</p>
     * <p>The engine schematic (your puzzle input) consists of a visual representation of the engine. There are lots of numbers and symbols you don't really understand, but apparently <b>any number adjacent to a symbol</b>, even diagonally, is a "part number" and should be included in your sum. (Periods (.) do not count as a symbol.)</p>
     * <p>Here is an example engine schematic:</p>
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
     * <p>In this schematic, two numbers are not part numbers because they are not adjacent to a symbol: 114 (top right) and 58 (middle right). Every other number is adjacent to a symbol and so is a part number; their sum is <b>4361</b>.</p>
     * <p>Of course, the actual engine schematic is much larger. <b>What is the sum of all of the part numbers in the engine schematic?</b></p>
     */
    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println(solve("day3/input.txt"));
    }

    static int solve(String fileName) throws IOException, URISyntaxException {
        List<String> input = FileReader.readFileToList(fileName);


        Engine engine = new Engine(input);

        List<Engine.Number> numbers = engine.getNumbers();

        return numbers.stream().filter(Engine.Number::hasSymbol).mapToInt(Engine.Number::getValue).sum();
    }
}
