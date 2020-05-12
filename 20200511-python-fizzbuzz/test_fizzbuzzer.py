import pytest

from fizzbuzzer import FizzBuzzer


@pytest.mark.parametrize("number, expected_string",
                         [(1, "1"),
                          (2, "2")])
def test_should_return_string_representation(number, expected_string):
    assert FizzBuzzer().fizz_buzz(number) == expected_string


@pytest.mark.parametrize("number", [3, 6])
def test_should_return_fizz_for_numbers_multiple_of_3(number):
    assert FizzBuzzer().fizz_buzz(number) == "Fizz"


@pytest.mark.parametrize("number", [5, 10])
def test_should_return_buzz_for_number_multiple_of_5(number):
    assert FizzBuzzer().fizz_buzz(number) == "Buzz"


def test_should_return_fizz_buzz_for_numbers_multiple_of_3_and_5():
    assert FizzBuzzer().fizz_buzz(15) == "FizzBuzz"
