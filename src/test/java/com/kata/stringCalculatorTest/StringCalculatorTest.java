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

	@Test
	public void sumsTwoNumbersSeperatedByComma() {
		assertEquals(StringCalculator.add("1,2"), 3);
		assertEquals(StringCalculator.add("1,3"), 4);
	}

	@Test
	public void sumsThreeNumbersSeperatedByComma() {
		assertEquals(StringCalculator.add("1,2,3"), 6);
	}

	@Test
	public void sumsNumbersDelimitedByNewLine() {
		assertEquals(StringCalculator.add("1\n2"), 3);
	}

	@Test
	public void sumsNumbersDelimitedByCommaOrNewLine() {
		assertEquals(StringCalculator.add("1,2\n3"), 6);

	}
}
