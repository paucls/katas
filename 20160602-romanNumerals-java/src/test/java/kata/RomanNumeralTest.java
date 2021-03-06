package kata;

import static org.junit.Assert.assertThat;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

public class RomanNumeralTest {

	@Test
	public void convert_1_is_I() {
		assertThat(RomanNumeral.convert(1), is("I"));
	}

	@Test
	public void corvert_3_means_three_I() {
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
	public void convert_6_means_V_and_add_I() {
		assertThat(RomanNumeral.convert(6), is("VI"));
	}

	@Test
	public void convert_8_means_V_and_add_three_I() {
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
	public void convert_14_means_X_and_substract_I_to_V() {
		assertThat(RomanNumeral.convert(14), is("XIV"));
	}

	@Test
	public void convert_16_means_X_and_add_V_and_add_I() {
		assertThat(RomanNumeral.convert(16), is("XVI"));
	}

	@Test
	public void convert_19_means_X_and_substract_I_to_X() {
		assertThat(RomanNumeral.convert(19), is("XIX"));
	}

	@Test
	public void convert_25_means_two_X_and_add_V() {
		assertThat(RomanNumeral.convert(25), is("XXV"));
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
	public void convert_369_means_three_C_and_add_L_and_add_X_and_subtract_I_to_X() {
		assertThat(RomanNumeral.convert(369), is("CCCLXIX"));
	}

    @Test
    public void convert_490_means_CD_and_add_XC() {
        assertThat(RomanNumeral.convert(490), is("CDXC"));
    }

	@Test
	public void convert_500_is_D() {
		assertThat(RomanNumeral.convert(500), is("D"));
	}

	@Test
	public void convert_1000_is_M() {
		assertThat(RomanNumeral.convert(1000), is("M"));
	}

	@Test
	public void convert_1990_means_M_and_add_CM_and_add_XC() {
		assertThat(RomanNumeral.convert(1990), is("MCMXC"));
	}

}
