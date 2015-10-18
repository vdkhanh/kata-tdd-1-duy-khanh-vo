package test;

import java.util.List;

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
		Assert.assertTrue(numberCreator.getNumbersAsList().isEmpty());
	}

	@Test
	public void whenInputOneNumberThenReturnListContainsThisNumber() {
		NumberCreator numberCreator = NumberCreator.create("1");
		Assert.assertFalse(numberCreator.getNumbersAsList().isEmpty());
		Assert.assertTrue(1 == numberCreator.getNumbersAsList().get(0));
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
		List<Integer> numbersAsList = numberCreator.getNumbersAsList();
		Assert.assertTrue(3 == numbersAsList.size());
		Assert.assertTrue(1 == numbersAsList.get(0));
		Assert.assertTrue(2 == numbersAsList.get(1));
		Assert.assertTrue(3 == numbersAsList.get(2));
	}
	
	@Test
	public void whenExtendDelimiterIsSpecifiedWithLongDelimiterThenReturnCorrectListOfNumber() {
		NumberCreator numberCreator = NumberCreator.create("//[**][%%%]\n1**2%%%3");
		List<Integer> numbersAsList = numberCreator.getNumbersAsList();
		Assert.assertTrue(3 == numbersAsList.size());
		Assert.assertTrue(1 == numbersAsList.get(0));
		Assert.assertTrue(2 == numbersAsList.get(1));
	}
}
