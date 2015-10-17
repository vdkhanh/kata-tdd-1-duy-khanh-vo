package test;

import org.junit.Assert;
import org.junit.Test;

import main.ExtendDelimiterNumberCreator;
import main.NumberCreator;

public class ExtendDelimiterNumberCreatorTest {
	private static final String NUMBER_AFTER_DELIMITER = "1***2***3";
	private static final String EXTEND_DELIMITER = "***";
	private static final String NUMBER_WITH_EXTEND_SPECIFIED_DELIMITER = "//[***]\n1***2***3";

	@Test
	public void whenGetDelimiterThenReturnCorrectDelimiter() {
		NumberCreator numberCreator = new ExtendDelimiterNumberCreator(NUMBER_WITH_EXTEND_SPECIFIED_DELIMITER);
		Assert.assertTrue(EXTEND_DELIMITER.equals(numberCreator.getDelimiters().get(0)));
	}

	@Test
	public void whenGetNumberAfterThenReturnCorrectNumber() {
		NumberCreator numberCreator = new ExtendDelimiterNumberCreator(NUMBER_WITH_EXTEND_SPECIFIED_DELIMITER);
		Assert.assertTrue(NUMBER_AFTER_DELIMITER.equals(numberCreator.getNumberAfterDelimiter()));
	}
	
}
