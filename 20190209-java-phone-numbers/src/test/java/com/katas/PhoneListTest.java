package com.katas;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneListTest {
    @Test
    public void should_be_consistent_when_has_one_phone_number() {
        var phoneList = new PhoneList(List.of("911"));

        assertThat(phoneList.isConsistent()).isTrue();
    }

    @Test
    public void should_not_be_consistent_when_a_number_is_prefix_of_another() {
        var phoneList = new PhoneList(List.of("911", "91176"));

        assertThat(phoneList.isConsistent()).isFalse();
    }

    @Test
    public void should_be_consistent_when_any_number_is_prefix_of_another() {
        var phoneList = new PhoneList(List.of("911", "976", "12110"));

        assertThat(phoneList.isConsistent()).isTrue();
    }
}
