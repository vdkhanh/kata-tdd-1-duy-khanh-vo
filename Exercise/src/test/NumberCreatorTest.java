package test;

import org.junit.Assert;
import org.junit.Test;

import main.DefaultNumberCreator;
import main.DelimiterNumberCreator;
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
}
