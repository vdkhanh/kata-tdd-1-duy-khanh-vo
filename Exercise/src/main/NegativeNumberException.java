package main;

import java.util.List;

public class NegativeNumberException extends Exception {
	private static final long serialVersionUID = 1L;
	private static String MESSAGE_TEMPLATE = "{0}, are not allowed";

	public NegativeNumberException(List<Integer> negativeNumbers) {
		super(getNegativeNumbersExceptionMessage(negativeNumbers));
	}

	private static String getNegativeNumbersExceptionMessage(List<Integer> negativeNumbers) {
		String message = "";
		for (Integer number : negativeNumbers) {
			message += " " + String.valueOf(number);
		}
		message=message.replaceFirst(" ", "");
		return MESSAGE_TEMPLATE.replace("{0}", message);
	}
}
