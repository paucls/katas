var assert = require('assert');

suite('FizzBuzz', function() {

	var fizzBuzz;

	setup(function() {
		fizzBuzz = new FizzBuzz();
	});

	test('should return 1 when number is 1', function() {
		assert.equal(1, fizzBuzz.parse(1));
	});

	test('should return Fizz when number is divisible by 3', function() {
		var result = fizzBuzz.parse(3);
		assert.equal("Fizz", result);
	});

	test('should return Buzz when number is divisible by 5', function() {
		var result = fizzBuzz.parse(5);
		assert.equal("Buzz", result);
	});

	test('should return FizzBuzz when number is divisible by 3 and 5', function() {
		var result = fizzBuzz.parse(15);
		assert.equal("FizzBuzz", result);
	});
});

function FizzBuzz() {
	this.parse = function(number) {

		var result = "";

		if (isDivisibleByThree(number)) {
			result += "Fizz";
		}

		if (isDivisibleByFive(number)) {
			result += "Buzz";
		}

		return result || number;
	};

	var isDivisibleByThree = function(number) {
		return (number % 3 === 0);
	};

	var isDivisibleByFive = function(number) {
		return (number % 5 === 0);
	};
}