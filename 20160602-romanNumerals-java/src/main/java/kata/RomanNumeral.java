package kata;

import static java.lang.Math.abs;

public class RomanNumeral {

	public static final String SYMBOL_FOR_1 = "I";
	public static final String SYMBOL_FOR_5 = "V";
	public static final String SYMBOL_FOR_10 = "X";

	public static String convert(int number) {

		String roman = "";

		int absDivisionBy10 = abs(number / 10);
		int modBy10 = number % 10;

		if (isMultipleOf10(number)) {
			roman += timesSymbol(absDivisionBy10, SYMBOL_FOR_10);
			return roman + convert(modBy10);
		}

		int modBy5 = number % 5;

		if (modBy5 == 4) {
			return SYMBOL_FOR_1 + convert(number + 1);
		}

		if (isMultipleOf5(number)) {
			return SYMBOL_FOR_5 + convert(modBy5);
		}

		roman += timesSymbol(modBy5, SYMBOL_FOR_1);

		return roman;
	}

	private static boolean isMultipleOf10(int number) {
		return number / 10 >= 1;
	}

	private static boolean isMultipleOf5(int number) {
		return number / 5 >= 1;
	}

	private static String timesSymbol(int times, String symbol) {
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < times; i++) {
			result.append(symbol);
		}

		return result.toString();
	}

}
