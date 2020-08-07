def fizz_buzz(number):
    """ FizzBuzzes the given number.
    >>> fizz_buzz(2)
    '2'
    >>> fizz_buzz(3)
    'Fizz'
    >>> fizz_buzz(4)
    '4'
    >>> fizz_buzz(5)
    'Buzz'
    >>> fizz_buzz(15)
    'FizzBuzz'
    """
    if multiple_of_3(number) and multiple_of_5(number):
        return "FizzBuzz"
    if multiple_of_3(number):
        return "Fizz"
    if multiple_of_5(number):
        return "Buzz"
    return str(number)


def multiple_of_3(number):
    return number % 3 == 0


def multiple_of_5(number):
    return number % 10 == 0
