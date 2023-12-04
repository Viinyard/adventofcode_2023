package com.adventofcode.soluce.day4;

import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class ASD {

    @Data
    public static class Scratchcard {
        private Integer cardNumber;
        private List<Integer> numbers;
        private List<Integer> winningNumbers;

        private Scratchcard previous;
        private Scratchcard next;

        private int numberOfCopies;

        public Scratchcard(Scratchcard previous, Integer cardNumber, List<Integer> numbers, List<Integer> winningNumbers) {
            Optional.ofNullable(previous).ifPresent(p -> p.setNext(this));
            this.previous = previous;
            this.cardNumber = cardNumber;
            this.numbers = numbers;
            this.winningNumbers = winningNumbers;
            this.numberOfCopies = 1;
        }

        public List<Integer> getMyWinNumbers() {
            return numbers.stream().filter(winningNumbers::contains).toList();
        }

        public int getNumberOfWinningNumbers() {
            return getMyWinNumbers().size();
        }

        public void copy(int numberOfCopies) {
            this.numberOfCopies += numberOfCopies;
        }

        public void scratch() {
            Stream.iterate(next, Objects::nonNull, Scratchcard::getNext).limit(getNumberOfWinningNumbers()).forEach(s -> s.copy(numberOfCopies));
        }

        public Scratchcard getFirst() {
            return Optional.ofNullable(previous).map(Scratchcard::getFirst).orElse(this);
        }

        public int getScore() {
            return (int) Math.pow(2, getMyWinNumbers().size() - 1);
        }

        @Override
        public String toString() {
            return "Scratchcard{" +
                    "cardNumber=" + cardNumber +
                    ", numbers=" + numbers +
                    ", winningNumbers=" + winningNumbers +
                    '}';
        }
    }
}
