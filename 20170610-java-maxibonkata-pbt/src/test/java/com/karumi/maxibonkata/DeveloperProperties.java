package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(JUnitQuickcheck.class)
public class DeveloperProperties {

    @Property
    public void developers_can_consume_zero_or_a_positive_number_of_maxibons(int numberMaxibons) {
        Developer developer = new Developer("John Snow", numberMaxibons);

        assertThat(developer.getNumberOfMaxibonsToGrab(), greaterThanOrEqualTo(0));
    }

    @Property
    public void developer_name_is_assigned_in_construction(String name, int numberMaxibons) {
        Developer developer = new Developer(name, numberMaxibons);

        assertThat(developer.getName(), is(name));
    }

}
