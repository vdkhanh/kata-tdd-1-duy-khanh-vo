package test;

import main.StringCalculator;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {
    @Test
    public void whenInputEmptyThenReturnZero() {
        Assert.assertTrue(StringCalculator.add("") == 0);
    }
}
