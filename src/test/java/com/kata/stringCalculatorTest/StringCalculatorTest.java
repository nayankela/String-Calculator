package com.kata.stringCalculatorTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.kata.stringCalculator.StringCalculator;

public class StringCalculatorTest {

	@Test
	public void sumsEmptyStringTo0() {
		assertEquals(StringCalculator.add(""), -1);
	}
}
