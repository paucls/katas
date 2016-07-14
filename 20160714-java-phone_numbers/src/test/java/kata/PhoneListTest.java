package kata;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PhoneListTest {

    PhoneList phoneList;

    @Before
    public void setup() {
        phoneList = new PhoneList();
    }

    @Test
    public void it_should_be_consistent_when_it_is_empty() {
        assertThat(phoneList.isConsistent(), is(true));
    }

    @Test
    public void it_should_be_consistent_when_it_has_one_phone() {
        phoneList.add("91125426");

        assertThat(phoneList.isConsistent(), is(true));
    }

    @Test
    public void it_should_not_be_consistent_when_a_phone_is_prefix_of_other() {
        phoneList.add("91125426");
        phoneList.add("911");

        assertThat(phoneList.isConsistent(), is(false));
    }

    @Test
    public void it_should_be_consistent_when_a_phone_contains_other_but_its_not_prefix() {
        phoneList.add("91125426");
        phoneList.add("112");

        assertThat(phoneList.isConsistent(), is(true));
    }

    @Test
    public void it_should_not_be_consistent_when_some_phones_are_prefix_of_others() {
        phoneList.add("91125426");
        phoneList.add("97 625 992");
        phoneList.add("083 123");
        phoneList.add("911");

        assertThat(phoneList.isConsistent(), is(false));
    }

    @Test
    public void it_should_not_be_consistent_when_some_phones_are_prefix_of_others_no_mather_order() {
        phoneList.add("911");
        phoneList.add("97 625 992");
        phoneList.add("91125426");
        phoneList.add("083 123");

        assertThat(phoneList.isConsistent(), is(false));
    }

}
