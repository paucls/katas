var assert = require('assert');

suite('FizzBuzz Kata', function() {

	var fizzBuzz = new FizzBuzz();

	test('Returns 1 when number is one', function() {
		assert.equal(1, fizzBuzz.parse(1));
	});

	test('Returns Fizz when number is multiple of three', function() {
		assert.equal("Fizz", fizzBuzz.parse(3));
	});

	test('Returns Buzz when number is multiple of five', function() {
		assert.equal("Buzz", fizzBuzz.parse(5));
	});

	test('Returns FizzBuzz when number is multiple of three and five', function() {
		assert.equal("FizzBuzz", fizzBuzz.parse(15));
	});
});

function FizzBuzz() {

	this.parse = function(number) {
		var result = "";

		if (isMultipleOfThree(number)) result += "Fizz";
		if (isMultipleOfFive(number)) result += "Buzz";
		if (!isMultipleOfThree(number) && !isMultipleOfFive(number)) result = number;
		
		return result;
	};

	var isMultipleOfThree = function(number) {
		return (number % 3 === 0);
	};

	var isMultipleOfFive = function(number) {
		return (number % 5 === 0);
	};
}