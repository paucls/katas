import {LeapYear} from "@/leap.year";

describe('Leap Year', () => {
    const leapYear = new LeapYear();

    it('should be typical common year when not divisible by 4', () => {
        expect(leapYear.isLeapYear(2001)).toBe(false);
    });

    it('should be typical leap year when divisible by 4', () => {
        expect(leapYear.isLeapYear(1996)).toBe(true);
    });

    it('should be atypical common year when divisible by 100', () => {
        expect(leapYear.isLeapYear(1900)).toBe(false);
    });

    it('should be atypical leap year when divisible by 400', () => {
        expect(leapYear.isLeapYear(2000)).toBe(true);
    });
});
