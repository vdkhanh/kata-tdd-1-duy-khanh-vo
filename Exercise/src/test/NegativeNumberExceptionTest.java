package test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import main.NegativeNumberException;

public class NegativeNumberExceptionTest {
	@Test
    public void whenOnlyOneNegativeNumberThenThrowExceptionWithThisValue() {
        List<Integer> negativeNumber = Arrays.asList(-1);
        Exception exception = new NegativeNumberException(negativeNumber);
        Assert.assertTrue("-1, are not allowed".equals(exception.getMessage()));
    }
	
	@Test
    public void whenTwoNegativeNumberThenThrowExceptionWithBothTwoValue() {
        List<Integer> negativeNumber = Arrays.asList(-1,-2);
        Exception exception = new NegativeNumberException(negativeNumber);
        Assert.assertTrue("-1 -2, are not allowed".equals(exception.getMessage()));
    }
}
