package test;

import main.NegativeNumberException;
import main.StringCalculator;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {
	@Test
	public void whenInputEmptyThenReturnZero() throws NegativeNumberException {
		Assert.assertTrue(0 == StringCalculator.add(""));
	}

	@Test
	public void whenInputOneNumberThenReturnThisNumber() throws NegativeNumberException {
		Assert.assertTrue(1 == StringCalculator.add("1"));
		Assert.assertTrue(2 == StringCalculator.add("2"));
	}

	@Test
	public void whenInputTwoNumberThenReturnSumOfThem() throws NegativeNumberException {
		Assert.assertTrue(1 + 2 == StringCalculator.add("1,2"));
		Assert.assertTrue(2 + 2 == StringCalculator.add("2,2"));
		Assert.assertTrue(StringCalculator.add("0,0") == 0);
	}

	@Test
	public void whenAnyNumberOfNumbersUsedThenReturnSumOfAll() throws NegativeNumberException {
		Assert.assertTrue(1 + 2 + 3 + 4 + 5 + 6 == StringCalculator.add("1,2,3,4,5,6"));
	}

	@Test
	public void whenInputTwoNumberWithNewLineThenReturnSumOfThem() throws NegativeNumberException {
		Assert.assertTrue(3 == StringCalculator.add("1\n2"));
	}

	@Test
	public void whenInputMoreNumberWithNewLineAndCommaThenReturnSumOfThem() throws NegativeNumberException {
		Assert.assertTrue(1 + 2 + 3 == StringCalculator.add("1\n2,3"));
	}

	@Test(expected = NegativeNumberException.class)
	public void whenInputNegativeNumberThenThrowNagativeNumberExecption() throws NegativeNumberException {
		StringCalculator.add("-1");
	}

	@Test
	public void whenInputNumberBiggerThan1000ThenIgnoreThisValue() throws NegativeNumberException {
		Assert.assertTrue(2 == StringCalculator.add("1001,2"));
	}
	@Test
	public void whenInputMoreThanOneNumberBiggerThan1000ThenIgnoreTheirValue() throws NegativeNumberException {
		Assert.assertTrue(2 == StringCalculator.add("1001,1002,2"));
		Assert.assertTrue(2 == StringCalculator.add("1001,1002,1003,2"));
	}
	@Test
	public void whenInput1000ThenPlusThisValue() throws NegativeNumberException {
		Assert.assertTrue(1002 == StringCalculator.add("1000,2"));
	}
	
	@Test
	public void whenInputNumberWithExtendDelimiterThenReturnSumOfAll() throws NegativeNumberException{
		Assert.assertTrue(6 == StringCalculator.add("//[***]\n1***2***3"));
	}
}
