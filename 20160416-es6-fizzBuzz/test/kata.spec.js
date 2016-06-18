describe('FizzBuzz', function () {

    let fizzBuzz;

    beforeEach(function () {
        fizzBuzz = new FizzBuzz();
    });

    it('should return the number when number is not divisible by 3 or 5', function () {
        expect(fizzBuzz.process(1)).toBe(1);
        expect(fizzBuzz.process(2)).toBe(2);
    });

    it('should return Fizz when number is divisible by 3', function () {
        expect(fizzBuzz.process(3)).toBe('Fizz');
        expect(fizzBuzz.process(9)).toBe('Fizz');
    });

    it('should return Buzz when number is divisible by 5', function () {
        expect(fizzBuzz.process(5)).toBe('Buzz');
    });

    it('should return FizzBuzz when number is divisible by 3 and 5', function () {
        expect(fizzBuzz.process(15)).toBe('FizzBuzz');
    });

});