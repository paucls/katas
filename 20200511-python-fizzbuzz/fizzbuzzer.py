class FizzBuzzer(object):
    def fizz_buzz(self, number):
        if number % 3 == 0 and number % 5 == 0:
            return "FizzBuzz"
        if number % 5 == 0:
            return "Buzz"
        if number % 3 == 0:
            return "Fizz"
        return str(number)
