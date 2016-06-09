package kata;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

public class RomanNumeralTest {

	@Test
	public void convert_1() {
		assertThat(RomanNumeral.convert(1), is("I"));
	}

	@Test
	public void corvert_3() {
		assertThat(RomanNumeral.convert(3), is("III"));
	}

	@Test
	public void convert_4_means_subtract_I_to_V() {
		assertThat(RomanNumeral.convert(4), is("IV"));
	}

	@Test
	public void convert_5_is_V() {
		assertThat(RomanNumeral.convert(5), is("V"));
	}

	@Test
	public void convert_6() {
		assertThat(RomanNumeral.convert(6), is("VI"));
	}

	@Test
	public void convert_8() {
		assertThat(RomanNumeral.convert(8), is("VIII"));
	}

	@Test
	public void convert_9_means_subtract_I_to_X() {
		assertThat(RomanNumeral.convert(9), is("IX"));
	}

	@Test
	public void convert_10_is_X() {
		assertThat(RomanNumeral.convert(10), is("X"));
	}

	@Test
	public void convert_13() {
		assertThat(RomanNumeral.convert(13), is("XIII"));
	}

	@Test
	public void convert_14() {
		assertThat(RomanNumeral.convert(14), is("XIV"));
	}

	@Test
	public void convert_15() {
		assertThat(RomanNumeral.convert(15), is("XV"));
	}

	@Test
	public void convert_16() {
		assertThat(RomanNumeral.convert(16), is("XVI"));
	}

	@Test
	public void convert_19() {
		assertThat(RomanNumeral.convert(19), is("XIX"));
	}

	@Test
	public void convert_25() {
		assertThat(RomanNumeral.convert(25), is("XXV"));
	}

	@Test
	public void convert_31() {
		assertThat(RomanNumeral.convert(31), is("XXXI"));
	}

	@Test
	public void convert_40_means_subtract_X_to_L() {
		assertThat(RomanNumeral.convert(40), is("XL"));
	}

    @Test
    public void convert_41_means_subtract_X_to_L_and_add_I() {
        assertThat(RomanNumeral.convert(41), is("XLI"));
    }

	@Test
	public void convert_50_is_L() {
		assertThat(RomanNumeral.convert(50), is("L"));
	}

    @Test
    public void convert_60_means_L_and_add_X() {
        assertThat(RomanNumeral.convert(60), is("LX"));
    }

    @Test
    public void convert_100_is_C() {
        assertThat(RomanNumeral.convert(100), is("C"));
    }

    @Test
    public void convert_90_means_subtract_X_to_C() {
        assertThat(RomanNumeral.convert(90), is("XC"));
    }

    @Test
    public void convert_101_means_C_and_add_I() {
        assertThat(RomanNumeral.convert(101), is("CI"));
    }

    @Test
    public void convert_300_means_three_C() {
        assertThat(RomanNumeral.convert(300), is("CCC"));
    }

}
