class FizzBuzzer(object):
    def fizz_buzz(self, number):
        if self.multiple_of_3(number) and self.multiple_of_5(number):
            return "FizzBuzz"
        if self.multiple_of_3(number):
            return "Fizz"
        if self.multiple_of_5(number):
            return "Buzz"
        return str(number)

    def multiple_of_3(self, number):
        return number % 3 == 0

    def multiple_of_5(self, number):
        return number % 5 == 0
