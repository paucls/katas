import {LeapYearCalculator} from "@/leap-year.calculator";

describe('Leap Year Calculator', () => {

    const leapYearCalculator = new LeapYearCalculator();

    it('should be leap year when its divisible by 4', () => {
        const isLeapYear = leapYearCalculator.isLeapYear(1996);

        expect(isLeapYear).toBe(true);
    });

    it('should be common year when its not divisible by 4', () => {
        const isLeapYear = leapYearCalculator.isLeapYear(2001);

        expect(isLeapYear).toBe(false);
    });
});
