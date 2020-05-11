import pytest

from fibonacci_sequence import FibonacciSequence


@pytest.mark.parametrize("index, expected_number",
                         [(0, 0),
                          (1, 1)])
def test_first_two_numbers_are_same_as_index(index, expected_number):
    assert FibonacciSequence().number_at(index) is expected_number


@pytest.mark.parametrize("index, expected_number",
                         [(3, 2),
                          (5, 5)])
def test_other_numbers_are_sum_of_the_two_preceding_ones(index, expected_number):
    assert FibonacciSequence().number_at(index) is expected_number
