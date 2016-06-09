package kata;

public class RomanNumeral {

	public static final String SYMBOL_FOR_1 = "I";
	public static final String SYMBOL_FOR_5 = "V";
	public static final String SYMBOL_FOR_10 = "X";
	public static final String SYMBOL_FOR_50 = "L";

	public static String convert(int number) {

		int modBy50 = number % 50;

		if (number >= 50) {
			return SYMBOL_FOR_50 + convert(modBy50);
		}

		if (modBy50 >= 40) {
			return SYMBOL_FOR_10 + SYMBOL_FOR_50 + convert(number % 40);
		}

		if (number >= 10) {
			return SYMBOL_FOR_10 + convert(number - 10);
		}

		int modBy5 = number % 5;

		if (modBy5 == 4) {
			return SYMBOL_FOR_1 + convert(number + 1);
		}

		if (number >= 5) {
			return SYMBOL_FOR_5 + convert(modBy5);
		}

		if (number >= 1) {
			return SYMBOL_FOR_1 + convert(number - 1);
		}

		return "";
	}

}
