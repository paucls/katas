import {LeapYearCalculator} from "@/leap-year.calculator";

describe('Leap Year Calculator', () => {

    it('should be leap year when its divisible by 4', () => {
        const year = 1996;

        const isLeapYear = new LeapYearCalculator().isLeapYear(year);

        expect(isLeapYear).toBe(true);
    });
});
