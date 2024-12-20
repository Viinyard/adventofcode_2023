package dev.vinyard.adventofcode.soluce.year2023.day2;

import dev.vinyard.aoc.plugins.solution.api.Solution;
import dev.vinyard.aoc.plugins.solution.api.annotation.AdventOfCodeSolution;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.List;


@AdventOfCodeSolution(year = 2023, day = 2, part = 1, description = "Cube Conundrum", link = "https://adventofcode.com/2023/day/2", tags = "unsolved")
public class Day2Part1Solution implements Solution<Long> {

    /**
     * <h2>--- Day 2: Cube Conundrum ---</h2>
     * <p>You're launched high into the atmosphere! The apex of your trajectory just barely reaches the surface of a large island floating in the sky. You gently land in a fluffy pile of leaves. It's quite cold, but you don't see much snow. An Elf runs over to greet you.</p>
     * <p>The Elf explains that you've arrived at <b>Snow Island</b> and apologizes for the lack of snow. He'll be happy to explain the situation, but it's a bit of a walk, so you have some time. They don't get many visitors up here; would you like to play a game in the meantime?</p>
     * <p>As you walk, the Elf shows you a small bag and some cubes which are either red, green, or blue. Each time you play this game, he will hide a secret number of cubes of each color in the bag, and your goal is to figure out information about the number of cubes.</p>
     * <p>To get information, once a bag has been loaded with cubes, the Elf will reach into the bag, grab a handful of random cubes, show them to you, and then put them back in the bag. He'll do this a few times per game.</p>
     * <p>You play several games and record the information from each game (your puzzle input). Each game is listed with its ID number (like the 11 in Game 11: ...) followed by a semicolon-separated list of subsets of cubes that were revealed from the bag (like 3 red, 5 green, 4 blue).</p>
     * <p>For example, the record of a few games might look like this:</p>
     * <pre>
     * Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
     * Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
     * Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
     * Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
     * Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
     * </pre>
     * <p>In game 1, three sets of cubes are revealed from the bag (and then put back again). The first set is 3 blue cubes and 4 red cubes; the second set is 1 red cube, 2 green cubes, and 6 blue cubes; the third set is only 2 green cubes.</p>
     * <p>The Elf would first like to know which games would have been possible if the bag contained <b>only 12 red cubes, 13 green cubes, and 14 blue cubes</b>?</p>
     * <p>In the example above, games 1, 2, and 5 would have been <b>possible</b> if the bag had been loaded with that configuration. However, game 3 would have been <b>impossible</b> because at one point the Elf showed you 20 red cubes at once; similarly, game 4 would also have been <b>impossible</b> because the Elf showed you 15 blue cubes at once. If you add up the IDs of the games that would have been possible, you get <b>8</b>.</p>
     * <p>Determine which games would have been possible if the bag had been loaded with only 12 red cubes, 13 green cubes, and 14 blue cubes. <b>What is the sum of the IDs of those games?</b></p>
     */
    @Override
    public Long solve(String input) {
        CharStream charStream = CharStreams.fromString(input);

        SolutionLexer lexer = new SolutionLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SolutionParser parser = new SolutionParser(tokens);
        ASD.Games games = parser.games().out;

        return games.getGames().stream().filter(g -> g.getHides().stream().map(ASD.Hide::getCubes).flatMap(List::stream).allMatch(c ->
                switch (c.getColor()) {
                    case RED -> c.getValue() <= 12;
                    case GREEN -> c.getValue() <= 13;
                    case BLUE -> c.getValue() <= 14;
                }
        )).mapToLong(ASD.Game::getValue).sum();
    }
}
