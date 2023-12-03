package com.adventofcode.soluce.day3;

import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public class Engine {

    private static EnginePart[][] parts;

    private final List<Engine.Number> numbers = new ArrayList<>();

    private final List<Engine.Symbol> symbols = new ArrayList<>();

    public Engine(List<String> input) {

        Dimension dimension = new Dimension(
                input.stream().map(String::length).max(Integer::compareTo).orElse(0),
                input.size());

        char[][] grid = new char[dimension.height+2][dimension.width+2];

        for (char[] lignes : grid) {
            Arrays.fill(lignes, '.');
        }

        for (int x = 0; x < dimension.height; x++) {
            for (int y = 0; y < dimension.width; y++) {
                grid[x+1][y+1] = input.get(x).charAt(y);
            }
        }

        parts = new EnginePart[grid.length][grid[0].length];

        for (int x = 0; x < grid.length; x++) {
            Number number = null;
            for (int y = 0; y < grid[0].length; y++) {

                if (Character.isDigit(grid[x][y])) {
                    Engine.Numeric numeric = new Engine.Numeric(new Position(x, y), Character.toString(grid[x][y]));
                    if (number == null) {
                        number = new Number();
                    }
                    number.add(numeric);
                    parts[x][y] = numeric;
                } else {
                    Optional.ofNullable(number).ifPresent(numbers::add);
                    number = null;

                    if (grid[x][y] == '.') {
                        parts[x][y] = new Engine.Empty(new Position(x, y));
                    } else  {
                        Engine.Symbol symbol = new Engine.Symbol(new Position(x, y), grid[x][y]);
                        parts[x][y] = symbol;
                        symbols.add(symbol);
                    }
                }

            }
        }
    }

    public  abstract class EnginePart {
        private final Position position;

        public EnginePart(Position position) {
            this.position = position;
        }

        public EnginePart getLeft() {
            return parts[position.x - 1][position.y];
        }

        public EnginePart getRight() {
            return parts[position.x + 1][position.y];
        }

        public EnginePart getTop() {
            return parts[position.x][position.y - 1];
        }

        public EnginePart getBottom() {
            return parts[position.x][position.y + 1];
        }

        public EnginePart getTopLeft() {
            return parts[position.x - 1][position.y - 1];
        }

        public EnginePart getTopRight() {
            return parts[position.x + 1][position.y - 1];
        }

        public EnginePart getBottomLeft() {
            return parts[position.x - 1][position.y + 1];
        }

        public EnginePart getBottomRight() {
            return parts[position.x + 1][position.y + 1];
        }

        public List<EnginePart> getNeighbours() {
            return Stream.of(
                    getLeft(),
                    getRight(),
                    getTop(),
                    getBottom(),
                    getTopLeft(),
                    getTopRight(),
                    getBottomLeft(),
                    getBottomRight()
            ).distinct().collect(Collectors.toList());
        }

        public boolean hasSymbols() {
            return getNeighbours().stream().anyMatch(Symbol.class::isInstance);
        }
    }

    public class Symbol extends EnginePart {
        char symbol;

        public Symbol(Position position, char symbol) {
            super(position);
            this.symbol = symbol;
        }

        public boolean isGear() {
            return symbol == '*';
        }

        public int getGearRatio() {
            List<Number> numbers = getNeighbours().stream()
                    .filter(Numeric.class::isInstance)
                    .map(Numeric.class::cast)
                    .map(Numeric::getNumber)
                    .distinct().toList();

            if (numbers.size() == 2) {
                return numbers.stream().map(Number::getValue).reduce(1, (a, b) -> a * b);
            } else {
                return 0;
            }
        }
    }

    @Getter
    public class Numeric extends EnginePart {

        String value;

        private Number number;

        public Numeric(Position position, String value) {
            super(position);
            this.value = value;
        }

        public void setNumber(Number number) {
            this.number = number;
        }
    }

    public class Empty extends EnginePart {
        public Empty(Position position) {
            super(position);
        }
    }

    public class Number {

        private final List<Numeric> numericList;
        public Number() {
            numericList = new ArrayList<>();
        }

        public void add(Numeric numeric) {
            numericList.add(numeric);
            numeric.setNumber(this);
        }

        public boolean hasSymbol() {
            return numericList.stream().anyMatch(Numeric::hasSymbols);
        }

        public int getValue() {
            return Integer.parseInt(numericList.stream().map(Numeric::getValue).collect(Collectors.joining()));
        }
    }

    public static class Position {
        private final Integer x;
        private final Integer y;

        public Position(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
    }

}
