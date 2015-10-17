package test;

import org.junit.Assert;
import org.junit.Test;

import main.DelimiterNumberCreator;
import main.NumberCreator;

public class DelimiterNumberCreatorTest {

	private static final String NUMBER_WITH_SPECIFIED_DELIMITER = "//;\n1;2;3";
	private static final String SEMI_COLON = ";";
	private static final String NUMBER_AFTER_DELIMITER = "1;2;3";
	

	@Test
	public void whenGetDelimiterThenReturnCorrectDelimiter() {
		NumberCreator numberCreator = new DelimiterNumberCreator(NUMBER_WITH_SPECIFIED_DELIMITER);
		Assert.assertTrue(SEMI_COLON.equalsIgnoreCase(numberCreator.getDelimiter()));
	}
	@Test
	public void whenGetNumberAfterDelimiterThenReturnCorrectNumbers() {
		NumberCreator numberCreator = new DelimiterNumberCreator(NUMBER_WITH_SPECIFIED_DELIMITER);
		Assert.assertTrue(NUMBER_AFTER_DELIMITER.equalsIgnoreCase(numberCreator.getNumberAfterDelimiter()));
	}
}
