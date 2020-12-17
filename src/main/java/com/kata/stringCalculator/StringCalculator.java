package com.kata.stringCalculator;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculator {

	private String delimeter;
	private String numbers;

	private StringCalculator(String delimiter, String numbers) {
		this.delimeter = delimiter;
		this.numbers = numbers;
	}

	private int sum() {
		ensureNonNegativeNumbers();
		return getNumber().sum();
	}

	private void ensureNonNegativeNumbers() {
		String negativeNumberSequence = getNumber().filter(n -> n < 0).mapToObj(Integer::toString)
				.collect(Collectors.joining(","));

		if (!negativeNumberSequence.isEmpty()) {

			throw new IllegalArgumentException("negative number : " + negativeNumberSequence);
		}
	}

	private IntStream getNumber() {
		if (numbers.isEmpty()) {
			return IntStream.empty();
		} else {
			return Stream.of(numbers.split(delimeter)).mapToInt(Integer::parseInt);
		}

//		return Arrays.stream(numbers.split(delimeter)).mapToInt(Integer::parseInt);
	}

	public static int add(String numbers) {
		return parseInput(numbers).sum();
	}

	private static StringCalculator parseInput(String numbers) {
		if (numbers.startsWith("//")) {
			String[] parts = numbers.split("\n", 2);
			return new StringCalculator(parts[0].substring(2), parts[1]);
		} else {
			return new StringCalculator(",|\n", numbers);
		}

	}
}
