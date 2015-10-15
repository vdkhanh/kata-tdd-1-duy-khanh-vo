package test;

import main.StringCalculator;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {
	@Test
	public void whenInputEmptyThenReturnZero() {
		Assert.assertTrue(0 == StringCalculator.add(""));
	}

	@Test
	public void whenInputOneNumberThenReturnThisNumber() {
		Assert.assertTrue(1 == StringCalculator.add("1"));
		Assert.assertTrue(2 == StringCalculator.add("2"));
	}

	@Test
	public void whenInputTwoNumberThenReturnSumOfThem() {
		Assert.assertTrue(1 + 2 == StringCalculator.add("1,2"));
		Assert.assertTrue(2 + 2 == StringCalculator.add("2,2"));
		Assert.assertTrue(StringCalculator.add("0,0") == 0);
	}

	@Test
	public void whenAnyNumberOfNumbersUsedThenReturnSumOfAll() {
		Assert.assertTrue(1 + 2 + 3 + 4 + 5 + 6 == StringCalculator.add("1,2,3,4,5,6"));
	}

	@Test
	public void whenInputTwoNumberWithNewLineThenReturnSumOfThem() {
		Assert.assertTrue(3 == StringCalculator.add("1\n2"));
	}

	@Test
	public void whenInputMoreNumberWithNewLineAndCommaThenReturnSumOfThem() {
		Assert.assertTrue(1 + 2 + 3 == StringCalculator.add("1\n2,3"));
	}
	
	@Test
	public final void whenDelimiterIsSpecifiedThenUseItToSplitNumbers() {
	    Assert.assertEquals(3+6+15, StringCalculator.add("//;n3;6;15"));
	}
}
