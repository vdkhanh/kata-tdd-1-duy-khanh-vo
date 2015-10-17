package main;

import java.util.ArrayList;
import java.util.List;

public class NumberCreator {
	private static final String SPLITTER = ",|\n";

	public List<Integer> getNumbersAsList(String numbers) {
		
		if (null == numbers || numbers.isEmpty()) {
			return new ArrayList<Integer>();
		}
		List<Integer> numbersAsList = new ArrayList<Integer>(); 
		for(String number: numbers.split(SPLITTER)){
			numbersAsList.add(Integer.parseInt(number));
		}
		return numbersAsList;
	}

	public static NumberCreator create(String numbers) {
		// TODO Auto-generated method stub
		return null;
	}
}
