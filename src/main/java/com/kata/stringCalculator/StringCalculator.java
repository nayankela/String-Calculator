package com.kata.stringCalculator;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {

	public static int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}
		Stream<String> num = Arrays.stream(numbers.split(","));
		return num.mapToInt(Integer::parseInt).sum();
	}
}
