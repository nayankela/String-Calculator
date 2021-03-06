package com.kata.stringCalculator;

import java.util.regex.Pattern;
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
		return getNumbers().sum();
	}

	private void ensureNonNegativeNumbers() {
		String negativeNumberSequence = getNumbers().filter(n -> n < 0).mapToObj(Integer::toString)
				.collect(Collectors.joining(","));

		if (!negativeNumberSequence.isEmpty()) {

			throw new IllegalArgumentException("negative number : " + negativeNumberSequence);
		}
	}

	private IntStream getNumbers() {
		if (numbers.isEmpty()) {
			return IntStream.empty();
		} else {
			return Stream.of(numbers.split(delimeter)).mapToInt(Integer::parseInt).map(n -> n % 1000);
		}

	}

	public static int add(String numbers) {
		return parseInput(numbers).sum();
	}

	private static StringCalculator parseInput(String numbers) {
		if (numbers.startsWith("//")) {
			String[] headerAndNumberSequence = numbers.split("\n", 2);
			// String header = parts[0];
			String delimeter = parseDelimiter(headerAndNumberSequence[0]);
			return new StringCalculator(delimeter, headerAndNumberSequence[1]);
		} else {
			return new StringCalculator(",|\n", numbers);
		}

	}

	private static String parseDelimiter(String header) {
		String delimiter = header.substring(2);
		if (delimiter.startsWith("[")) {

			delimiter = delimiter.substring(1, delimiter.length() - 1);
		}
		return Stream.of(delimiter.split("]\\[")).map(Pattern::quote).collect(Collectors.joining("|"));
	}
}
