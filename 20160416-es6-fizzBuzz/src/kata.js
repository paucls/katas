'use strict';

const FIZZ = 'Fizz';
const BUZZ = 'Buzz';

class FizzBuzz {
    process(number) {
        let result = '';

        result += this._divisibleBy3Policy(number);
        result += this._divisibleBy5Policy(number);

        return result || number;
    }

    _divisibleBy3Policy(number) {
        return (number % 3 === 0) ? FIZZ : '';
    }

    _divisibleBy5Policy(number) {
        return (number % 5 === 0) ? BUZZ : '';
    }
}