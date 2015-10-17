package test;

import org.junit.Assert;
import org.junit.Test;

import main.ExtendDelimiterNumberCreator;
import main.NumberCreator;

public class ExtendDelimiterNumberCreatorTest {
	@Test
	public void whenGetDelimiterThenReturnCorrectDelimiter() {
		NumberCreator numberCreator = new ExtendDelimiterNumberCreator("//[***]\n1***2***3");
		Assert.assertTrue("***".equals(numberCreator.getDelimiter()));
	}
}
