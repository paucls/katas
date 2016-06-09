package kata;

public class RomanNumeral {

	public static final String SYMBOL_FOR_1 = "I";
	public static final String SYMBOL_FOR_5 = "V";
	public static final String SYMBOL_FOR_10 = "X";
	public static final String SYMBOL_FOR_50 = "L";
	public static final String SYMBOL_FOR_100 = "C";

	public static String convert(int number) {

		if (number >= 100) {
			return SYMBOL_FOR_100 + convert(number - 100);
		}

		if (number >= 90) {
			return SYMBOL_FOR_10 + convert(number + 10);
		}

		if (number >= 50) {
			return SYMBOL_FOR_50 + convert(number - 50);
		}

		if (number >= 40) {
			return SYMBOL_FOR_10 + convert(number + 10);
		}

		if (number >= 10) {
			return SYMBOL_FOR_10 + convert(number - 10);
		}

		if (number >= 9) {
			return SYMBOL_FOR_1 + convert(number + 1);
		}

		if (number >= 5) {
			return SYMBOL_FOR_5 + convert(number - 5);
		}

		if (number >= 4) {
			return SYMBOL_FOR_1 + convert(number + 1);
		}

		if (number >= 1) {
			return SYMBOL_FOR_1 + convert(number - 1);
		}

		return "";
	}

}
