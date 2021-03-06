package com.jubobs.corksoftwarecrafstmanship.propertybasedtesting.workshop;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Assume;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.fail;
import static org.hamcrest.Matchers.*;
import static org.junit.Assume.assumeThat;

@RunWith(Enclosed.class)
public final class RecentlyUsedList_spec {

    private static final String ITEM = "An Item";

    @RunWith(JUnitQuickcheck.class)
    public static final class A_new_list {

        @Property
        public void cannot_be_instantiated_with_a_nonpositive_capacity(int capacity) {
            assumeThat(capacity, lessThanOrEqualTo(0));

            try {
                ListBasedRecentlyUsedList.newInstance(capacity);
                fail("Should have thrown IllegalArgumentException but did not!");
            } catch (IllegalArgumentException e) {
                assertThat(e.getMessage()).isEqualTo("List can not be instantiated with non positive capacity");
            }
        }

        @Property
        public void can_be_instantiated_with_a_positive_capacity(@InRange(minInt = 1, maxInt = 1000) int capacity) {
            RecentlyUsedList recentlyUsedList = ListBasedRecentlyUsedList.newInstance(capacity);

            assertThat(recentlyUsedList).isNotNull();
        }

        @Property
        public void is_empty(@InRange(minInt = 1, maxInt = 1000) int capacity) {
            RecentlyUsedList recentlyUsedList = ListBasedRecentlyUsedList.newInstance(capacity);

            assertThat(recentlyUsedList.isEmpty()).isTrue();
        }

    }

    @RunWith(JUnitQuickcheck.class)
    public static final class An_empty_list {

        @Property
        public void retains_a_single_addition() {
            RecentlyUsedList recentlyUsedList = ListBasedRecentlyUsedList.newInstance(5);

            recentlyUsedList.push(ITEM);

            assertThat(recentlyUsedList.size()).isEqualTo(1);
            assertThat(recentlyUsedList.elementAt(0)).isEqualTo(ITEM);
        }

        @Ignore
        @Property
        public void retains_unique_additions_in_stack_order_up_to_its_capacity() {

        }

    }

    @RunWith(JUnitQuickcheck.class)
    public static final class An_nonempty_list {

        @Ignore
        @Property
        public void is_unchanged_when_its_head_item_is_re_added() {

        }

    }

    @RunWith(JUnitQuickcheck.class)
    public static final class Any_list {

        @Property
        public void rejects_the_addition_of_a_null_item() {
            RecentlyUsedList recentlyUsedList = ListBasedRecentlyUsedList.newInstance(5);

            try {
                recentlyUsedList.push(null);
                fail("Should have thrown IllegalArgumentException but did not!");
            } catch (IllegalArgumentException e) {
                assertThat(e.getMessage()).isEqualTo("Null items can not be added to the list");
            }
        }

        @Ignore
        @Property
        public void of_at_least_two_items_moves_a_non_head_item_to_head_when_that_item_is_re_added() {

        }

        @Property
        public void that_gets_cleared_yields_an_empty_list_of_the_same_capacity() {
            RecentlyUsedList recentlyUsedList = ListBasedRecentlyUsedList.newInstance(5);

            recentlyUsedList.push(ITEM);
            assertThat(recentlyUsedList.isEmpty()).isFalse();

            recentlyUsedList.clear();

            assertThat(recentlyUsedList.isEmpty()).isTrue();
        }

        @Ignore
        @Property
        public void allows_indexing_within_its_bounds() {

        }

        @Ignore
        @Property
        public void rejects_negative_indexing() {

        }

        @Ignore
        @Property
        public void rejects_indexing_past_its_end() {

        }

        @Ignore
        @Test
        public void satisfies_the_equals_hashCode_contract() {

        }

        @Ignore
        @Property
        public void has_a_sensible_toString_implementation() {

        }

    }

}
