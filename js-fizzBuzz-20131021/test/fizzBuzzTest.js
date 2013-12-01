var assert = require('assert');

suite('FizzBuzz', function() {
	suite('#parse', function() {
		var fizzBuzz;

		setup(function() {
			fizzBuzz = new FizzBuzz();
		});

		test('should return 1 if number is 1', function() {
			assert.equal(fizzBuzz.parse(1), 1);
		});
	
		test('should return 2 if number is 2', function() {
			assert.equal(fizzBuzz.parse(2), 2);
		});
	
		test('should return Fizz if number is divisible by 3', function() {
			assert.equal(fizzBuzz.parse(3), "Fizz");
		});

		test('should return Buzz if number is divisible by 5', function() {
			assert.equal(fizzBuzz.parse(5), "Buzz");
		});

		test('should return FizzBuzz if number is divisible by 3 and 5', function() {
			assert.equal(fizzBuzz.parse(15), "FizzBuzz");
		});

		test('should return Fizz if number contains 3', function() {
			assert.equal(fizzBuzz.parse(31), "Fizz");
		});
	});
});

function FizzBuzz() {
	this.parse = function(number) {
		var result = "";

		if (isFizz(number)) result += "Fizz";
		if (isBuzz(number)) result += "Buzz";

		return result || number;
	};

	var isFizz = function(number) {
		return (number % 3 === 0 || number.toString().indexOf('3') === 0);
	};

	var isBuzz = function(number) {
		return (number % 5 === 0);
	};
}