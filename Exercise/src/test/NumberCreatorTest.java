package test;

import org.junit.Assert;
import org.junit.Test;

import main.NumberCreator;

public class NumberCreatorTest {
	@Test
	public void whenInputEmptyThenReturnEmptyList() {
		NumberCreator numberCreator = new NumberCreator();
		Assert.assertTrue(numberCreator.getNumbersAsList("").isEmpty());
	}

	@Test
	public void whenInputOneNumberThenReturnListContainsThisNumber() {
		NumberCreator numberCreator = new NumberCreator();
		Assert.assertFalse(numberCreator.getNumbersAsList("1").isEmpty());
		Assert.assertTrue(1 == numberCreator.getNumbersAsList("1").get(0));
	}
}
