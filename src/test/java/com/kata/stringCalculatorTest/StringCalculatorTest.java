package com.kata.stringCalculatorTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.kata.stringCalculator.StringCalculator;

public class StringCalculatorTest {

	@Test
	public void sumsEmptyStringTo0() {
		assertEquals(StringCalculator.add(""), 0);
	}

	@Test
	public void sumsSingleNumberToItself() {
		assertEquals(StringCalculator.add("5"), 5);
		assertEquals(StringCalculator.add("42"), 42);
	}
}
