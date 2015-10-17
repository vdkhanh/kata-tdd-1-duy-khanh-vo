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
		Assert.assertTrue(DEFAULT_DELIMITER.equalsIgnoreCase(numberCreator.getDelimiter()));
	}

	@Test
	public void whenGetNumbersAfterDelimiterThenReturnTheSameWithInputNumbers() {
		NumberCreator numberCreator = new DefaultNumberCreator(NUMBER_WITH_DEFAULT_DELIMITER);
		Assert.assertTrue(NUMBER_WITH_DEFAULT_DELIMITER.equalsIgnoreCase(numberCreator.getNumberAfterDelimiter()));
	}
}
