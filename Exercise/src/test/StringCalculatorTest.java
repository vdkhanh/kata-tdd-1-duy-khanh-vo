package test;

import main.StringCalculator;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {
	@Test
	public void whenInputEmptyThenReturnZero() {
		Assert.assertTrue(StringCalculator.add("") == 0);
	}

	@Test
	public void whenInputOneNumberThenReturnThisNumber() {
		Assert.assertTrue(StringCalculator.add("1") == 1);
		Assert.assertTrue(StringCalculator.add("2") == 2);
	}

	@Test
	public void whenInputTwoNumberThenReturnSumOfThem() {
		Assert.assertTrue(StringCalculator.add("1,2") == 3);
		Assert.assertTrue(StringCalculator.add("2,2") == 4);
		Assert.assertTrue(StringCalculator.add("0,0") == 0);
	}

	@Test(expected = RuntimeException.class)
	public void whenInputThreeNumberThenReturnException() {
		StringCalculator.add("1,2,3");
	}
	
	@Test(expected = RuntimeException.class)
	public void whenInputMoreThanTwoNumberThenReturnException() {
		StringCalculator.add("1,2,3,4,5,6");
	}
}
