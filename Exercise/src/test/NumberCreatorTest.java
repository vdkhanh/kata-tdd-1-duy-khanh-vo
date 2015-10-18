package test;

import org.junit.Assert;
import org.junit.Test;

import main.DefaultNumberCreator;
import main.DelimiterNumberCreator;
import main.ExtendDelimiterNumberCreator;
import main.NumberCreator;

public class NumberCreatorTest {
	@Test
	public void whenInputEmptyThenReturnEmptyList() {
		NumberCreator numberCreator = NumberCreator.create("");
		Assert.assertTrue(numberCreator.getNumbersAsList("").isEmpty());
	}

	@Test
	public void whenInputOneNumberThenReturnListContainsThisNumber() {
		NumberCreator numberCreator = NumberCreator.create("1");
		Assert.assertFalse(numberCreator.getNumbersAsList("1").isEmpty());
		Assert.assertTrue(1 == numberCreator.getNumbersAsList("1").get(0));
	}

	@Test
	public void whenDelimiterIsNotSpecifiedThenReturnDefaultNumberCreator() {
		NumberCreator numberCreator = NumberCreator.create("");
		Assert.assertTrue(numberCreator instanceof DefaultNumberCreator);
	}

	@Test
	public void whenDelimiterIsSpecifiedThenReturnDelimiterNumberCreator() {
		NumberCreator numberCreator = NumberCreator.create("//");
		Assert.assertTrue(numberCreator instanceof DelimiterNumberCreator);
	}

	@Test
	public void whenExtendDelimiterIsSpecifiedThenReturnExtendDelimiterNumberCreator() {
		NumberCreator numberCreator = NumberCreator.create("//[");
		Assert.assertTrue(numberCreator instanceof ExtendDelimiterNumberCreator);
	}

	@Test
	public void whenExtendDelimiterIsSpecifiedThenReturnCorrectListOfNumber() {
		NumberCreator numberCreator = NumberCreator.create("//[*][%]\n1*2%3");
		Assert.assertTrue(3 == numberCreator.getNumbersAsList("//[*][%]\n1*2%3").size());
		Assert.assertTrue(1 == numberCreator.getNumbersAsList("//[*][%]\n1*2%3").get(0));
		Assert.assertTrue(2 == numberCreator.getNumbersAsList("//[*][%]\n1*2%3").get(1));
	}
}
