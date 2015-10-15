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
	
	@Test
	public void whenAnyNumberOfNumbersUsedThenReturnSumOfAll() {
		Assert.assertTrue(1+2+3+4+5+6 == StringCalculator.add("1,2,3,4,5,6"));
	}
	@Test
	public void whenInputTwoNumberWithNewLineThenReturnSumOfThem() {
		Assert.assertTrue(StringCalculator.add("1\n2") == 3);
	}
	@Test
	public void whenInputMoreNumberWithNewLineAndCommaThenReturnSumOfThem() {
		Assert.assertTrue(1+2+3 == StringCalculator.add("1\n2,3"));
	}
}
