package com.adventofcode.soluce.day4;

import lombok.Data;

import java.util.List;

public class ASD {

    @Data
    public static class Scratchcard {
        private Integer cardNumber;
        private List<Integer> numbers;
        private List<Integer> winningNumbers;

        public Scratchcard(Integer cardNumber, List<Integer> numbers, List<Integer> winningNumbers) {
            this.cardNumber = cardNumber;
            this.numbers = numbers;
            this.winningNumbers = winningNumbers;
        }

        public List<Integer> getMyWinNumbers() {
            return numbers.stream().filter(winningNumbers::contains).toList();
        }

        public int getScore() {
            return (int) Math.pow(2, getMyWinNumbers().size() - 1);
        }
    }
}
