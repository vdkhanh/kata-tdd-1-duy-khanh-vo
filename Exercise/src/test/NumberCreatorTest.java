package test;

import org.junit.Assert;
import org.junit.Test;

import main.NumberCreator;

public class NumberCreatorTest {
	@Test
	public void whenInputEmptyThenReturnEmptyList() {
		NumberCreator numberCreator = new NumberCreator();
		Assert.assertTrue(numberCreator.create("").isEmpty());
	}

	@Test
	public void whenInputOneNumberThenReturnListContainsThisNumber() {
		NumberCreator numberCreator = new NumberCreator();
		Assert.assertFalse(numberCreator.create("1").isEmpty());
	}
}
