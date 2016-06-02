package kata;

public class RomanNumeral {

	public static final String SYMBOL_FOR_1 = "I";
	public static final String SYMBOL_FOR_5 = "V";
	public static final String SYMBOL_FOR_10 = "X";

	public static String convert(int number) {

		if (number == 4) {
			return SYMBOL_FOR_1 + SYMBOL_FOR_5;
		}

		if (number == 9) {
			return SYMBOL_FOR_1 + SYMBOL_FOR_10;
		}

		StringBuffer result = new StringBuffer();
		int mod = number % 5;

		boolean isDivisibleBy5 = number / 5 == 1;

		if (isDivisibleBy5) {
			appendSymbol(result, SYMBOL_FOR_5);
		}

		for (int i = 0; i < mod; i++) {
			appendSymbol(result, SYMBOL_FOR_1);
		}

		return result.toString();
	}

	private static void appendSymbol(StringBuffer romanNumeralSB, String symbolFor5) {
		romanNumeralSB.append(symbolFor5);
	}

}
