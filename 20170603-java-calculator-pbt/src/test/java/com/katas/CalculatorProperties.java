package com.katas;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Before;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnitQuickcheck.class)
public class CalculatorProperties {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Property
    public void add_operation_is_commutative_change_order_operands_do_not_change_result(int a, int b) {
        int result1 = calculator.add(a, b);
        int result2 = calculator.add(b, a);

        assertThat(result1, equalTo(result2));
    }

    @Property
    public void add_operation_is_associative_when_adding_three_or_more_numbers_the_order_of_operations_does_not_matter(int a, int b, int c) {
        int result1 = calculator.add(calculator.add(a, b), c);
        int result2 = calculator.add(a, calculator.add(b, c));

        assertThat(result1, equalTo(result2));
    }

    @Property
    public void add_operation_has_identity_element_when_adding_zero_to_any_number_the_quantity_does_not_change(int a) {
        int result = calculator.add(a, 0);

        assertThat(result, equalTo(a));
    }

}
