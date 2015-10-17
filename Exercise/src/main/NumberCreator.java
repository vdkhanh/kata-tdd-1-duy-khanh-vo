package main;

import java.util.ArrayList;
import java.util.List;

public abstract class NumberCreator {
	
	private static final String SIGNAL_OF_CHANGE_DELIMITER = "//";

	public abstract String getDelimiter(String numbers);
	public abstract String getNumberWithOutdelimiter(String numbers);
	public List<Integer> getNumbersAsList(String numbers) {
		
		if (null == numbers || numbers.isEmpty()) {
			return new ArrayList<Integer>();
		}
		NumberCreator numberCreator = NumberCreator.create(numbers);
		
		String delimiter = numberCreator.getDelimiter(numbers);
		
		List<Integer> numbersAsList = new ArrayList<Integer>(); 
		for(String number: numbers.split(delimiter)){
			numbersAsList.add(Integer.parseInt(number));
		}
		return numbersAsList;
	}

	public static NumberCreator create(String numbers) {
		if(isChanngeDelimiter(numbers)){
			return new DelimiterNumberCreator();
		}
		return new DefaultNumberCreator();
	}
	private static boolean isChanngeDelimiter(String numbers) {
		return numbers.startsWith(SIGNAL_OF_CHANGE_DELIMITER);
	}
}
