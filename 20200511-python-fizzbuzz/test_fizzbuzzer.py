from fizzbuzzer import FizzBuzzer


def test_should_return_string_1_for_number_1():
    result = FizzBuzzer().fizz_buzz(1)
    assert result is "1"
