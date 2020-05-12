from fizzbuzzer import FizzBuzzer


def test_should_return_string_1_for_number_1():
    assert FizzBuzzer().fizz_buzz(1) == "1"


def test_should_return_string_2_for_number_2():
    assert FizzBuzzer().fizz_buzz(2) == "2"


def test_should_return_fizz_for_number_3():
    assert FizzBuzzer().fizz_buzz(3) == "Fizz"


def test_should_return_fizz_for_number_multiple_of_3():
    assert FizzBuzzer().fizz_buzz(6) == "Fizz"
