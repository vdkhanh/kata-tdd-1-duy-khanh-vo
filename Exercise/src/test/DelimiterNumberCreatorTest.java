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
	@Test
	public void whenInputNumberContainsNegativeNumberThenReturnTrue(){
		NumberCreator numberCreator = new DelimiterNumberCreator("//;\n-1");
		Assert.assertTrue(numberCreator.containNegativeNumber());
	}
	@Test
	public void whenInputNumberNotContainsNegativeNumberThenReturnFalse(){
		NumberCreator numberCreator = new DelimiterNumberCreator("//;\n1");
		Assert.assertFalse(numberCreator.containNegativeNumber());
	}
	
	@Test
	public void whenInputOneNegativeNumberThenReturnListOneNegativeNumber() {
		NumberCreator numberCreator = new DelimiterNumberCreator("//;\n-1;1;2");
		Assert.assertFalse(numberCreator.getNegativeNumbers().isEmpty());
		Assert.assertTrue(1 == numberCreator.getNegativeNumbers().size());
		Assert.assertTrue(-1 == numberCreator.getNegativeNumbers().get(0));

	}

	@Test
	public void whenInputTwoNegativeNumberThenReturnListTwoNegativeNumber() {
		NumberCreator numberCreator = new DelimiterNumberCreator("//;\n-1;1;-2");
		Assert.assertFalse(numberCreator.getNegativeNumbers().isEmpty());
		Assert.assertTrue(2 == numberCreator.getNegativeNumbers().size());
		Assert.assertTrue(-1 == numberCreator.getNegativeNumbers().get(0));
		Assert.assertTrue(-2 == numberCreator.getNegativeNumbers().get(1));
	}

	@Test
	public void whenInputNoneNegativeNumberThenReturnEmptyList() {
		NumberCreator numberCreator = new DelimiterNumberCreator("");
		Assert.assertTrue(numberCreator.getNegativeNumbers().isEmpty());
	}
}
