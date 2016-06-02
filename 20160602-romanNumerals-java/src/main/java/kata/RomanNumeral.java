package kata;

public class RomanNumeral {

	public static final String SYMBOL_FOR_1 = "I";
    public static final String SYMBOL_FOR_5 = "V";

    public static String convert(int number) {

		if (number == 5) {
			return SYMBOL_FOR_5;
		}

		if (number == 4) {
			return SYMBOL_FOR_1 + SYMBOL_FOR_5;
		}

		StringBuffer romanNumeralSB = new StringBuffer();

		for (int i = 0; i < number; i++) {
			romanNumeralSB.append(SYMBOL_FOR_1);
		}

		return romanNumeralSB.toString();
	}

}
