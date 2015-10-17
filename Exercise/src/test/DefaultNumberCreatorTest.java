package test;

import org.junit.Assert;
import org.junit.Test;

import main.DefaultNumberCreator;
import main.NumberCreator;

public class DefaultNumberCreatorTest {

	private static final String NUMBER_WITH_DEFAULT_DELIMITER = "1,2\n3";
	private static final String DEFAULT_DELIMITER = ",|\n";

	@Test
	public void whenGetDelimiterThenReturnDefaultDelimiter() {
		NumberCreator numberCreator = new DefaultNumberCreator(NUMBER_WITH_DEFAULT_DELIMITER);
		Assert.assertTrue(DEFAULT_DELIMITER.equalsIgnoreCase(numberCreator.getDelimiters().get(0)));
	}

	@Test
	public void whenGetNumbersAfterDelimiterThenReturnTheSameWithInputNumbers() {
		NumberCreator numberCreator = new DefaultNumberCreator(NUMBER_WITH_DEFAULT_DELIMITER);
		Assert.assertTrue(NUMBER_WITH_DEFAULT_DELIMITER.equalsIgnoreCase(numberCreator.getNumberAfterDelimiter()));
	}

	@Test
	public void whenInputNumberContainsNegativeNumberThenReturnTrue() {
		NumberCreator numberCreator = new DefaultNumberCreator("-1");
		Assert.assertTrue(numberCreator.containNegativeNumber());
	}

	@Test
	public void whenInputNumberNotContainsNegativeNumberThenReturnFalse() {
		NumberCreator numberCreator = new DefaultNumberCreator("1");
		Assert.assertFalse(numberCreator.containNegativeNumber());
	}

	@Test
	public void whenInputOneNegativeNumberThenReturnListOneNegativeNumber() {
		NumberCreator numberCreator = new DefaultNumberCreator("-1,1,2");
		Assert.assertFalse(numberCreator.getNegativeNumbers().isEmpty());
		Assert.assertTrue(1 == numberCreator.getNegativeNumbers().size());
		Assert.assertTrue(-1 == numberCreator.getNegativeNumbers().get(0));

	}

	@Test
	public void whenInputTwoNegativeNumberThenReturnListTwoNegativeNumber() {
		NumberCreator numberCreator = new DefaultNumberCreator("-1,1,-2");
		Assert.assertFalse(numberCreator.getNegativeNumbers().isEmpty());
		Assert.assertTrue(2 == numberCreator.getNegativeNumbers().size());
		Assert.assertTrue(-1 == numberCreator.getNegativeNumbers().get(0));
		Assert.assertTrue(-2 == numberCreator.getNegativeNumbers().get(1));
	}

	@Test
	public void whenInputNoneNegativeNumberThenReturnEmptyList() {
		NumberCreator numberCreator = new DefaultNumberCreator("");
		Assert.assertTrue(numberCreator.getNegativeNumbers().isEmpty());
	}
}
