package com.adventofcode.soluce.day7;

import com.adventofcode.day7.grammar.Day7Lexer;
import com.adventofcode.day7.grammar.Day7Parser;
import com.adventofcode.utils.FileReader;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Puzzle2 {

    /**
     * <p>--- Part Two ---</p>
     * <p>To make things a little more interesting, the Elf introduces one additional rule. Now, J cards are <a href="https://en.wikipedia.org/wiki/Joker_(playing_card)">jokers</a> - wildcards that can act like whatever card would make the hand the strongest type possible.</p>
     * <p>To balance this, <b>J cards are now the weakest</b> individual cards, weaker even than 2. The other cards stay in the same order: A, K, Q, T, 9, 8, 7, 6, 5, 4, 3, 2, J.</p>
     * <p>J cards can pretend to be whatever card is best for the purpose of determining hand type; for example, QJJQ2 is now considered <b>four of a kind</b>. However, for the purpose of breaking ties between two hands of the same type, J is always treated as J, not the card it's pretending to be: JKKK2 is weaker than QQQQ2 because J is weaker than Q.</p>
     * <p>Now, the above example goes very differently:</p>
     * <pre>
     * 32T3K 765
     * T55J5 684
     * KK677 28
     * KTJJT 220
     * QQQJA 483
     * </pre>
     * <ul>
     * <li>32T3K is still the only <b>one pair</b>; it doesn't contain any jokers, so its strength doesn't increase.</li>
     * <li>KK677 is now the only <b>two pair</b>, making it the second-weakest hand.</li>
     * <li>T55J5, KTJJT, and QQQJA are now all <b>four of a kind</b>! T55J5 gets rank 3, QQQJA gets rank 4, and KTJJT gets rank 5.</li>
     * </ul>
     * <p>With the new joker rule, the total winnings in this example are <b>5905</b>.</p>
     * <p>Using the new joker rule, find the rank of every hand in your set. <b>What are the new total winnings?</b></p>
     */
    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println(solve("day7/input.txt"));
    }

    public static long solve(String fileName) throws IOException, URISyntaxException {
        String input = FileReader.readFileToString(fileName);

        CharStream charStream = CharStreams.fromString(input);

        Day7Lexer lexer = new Day7Lexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Day7Parser parser = new Day7Parser(tokens);

        Function<String, ASD.Card> fromValue = s ->
                switch (s) {
                    case "J" -> ASD.Card.JOKER;
                    default -> ASD.Card.fromValue(s);
                };

        List<ASD.Game> games = parser.games(fromValue).out;

        Collections.sort(games);

        return Stream.iterate(0, i -> i + 1).limit(games.size()).mapToLong(i -> games.get(i).getBid() * (i + 1)).sum();
    }
}
