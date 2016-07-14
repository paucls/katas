package kata;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PhoneListTest {

    @Test
    public void it_should_be_consistent_when_it_is_empty() {
        PhoneList phoneList = new PhoneList();

        assertThat(phoneList.isConsistent(), is(true));
    }

    @Test
    public void it_should_be_consistent_when_it_has_one_phone() {
        PhoneList phoneList = new PhoneList();
        phoneList.add("91125426");

        assertThat(phoneList.isConsistent(), is(true));
    }
}
