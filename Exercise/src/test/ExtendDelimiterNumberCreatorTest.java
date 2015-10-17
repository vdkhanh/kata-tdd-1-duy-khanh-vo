package test;

import org.junit.Assert;
import org.junit.Test;

import main.ExtendDelimiterNumberCreator;
import main.NumberCreator;

public class ExtendDelimiterNumberCreatorTest {
	private static final String EXTEND_DELIMITER = "***";
	private static final String NUMBER_WITH_EXTEND_SPECIFIED_DELIMITER = "";

	@Test
	public void whenGetDelimiterThenReturnCorrectDelimiter() {
		NumberCreator numberCreator = new ExtendDelimiterNumberCreator(NUMBER_WITH_EXTEND_SPECIFIED_DELIMITER);
		Assert.assertTrue(EXTEND_DELIMITER.equals(numberCreator.getDelimiter()));
	}
}
