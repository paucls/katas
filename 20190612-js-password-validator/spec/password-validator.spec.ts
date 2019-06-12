import { PasswordValidator } from '../src/password-validator';

describe('Password Validator', () => {

    let passwordValidator;

    beforeEach(() => {
        passwordValidator = new PasswordValidator();
    });

    it('should tell when a password is valid', () => {
        expect(passwordValidator.validate('Abcd_123')).toBe(true);
    });

    it('should tell password is invalid when it has less than 8 characters', () => {
        expect(passwordValidator.validate('Abcd_12')).toBe(false);
    });

    it('should tell password is invalid when it does not contain a capital letter', () => {
        expect(passwordValidator.validate('abcd_123')).toBe(false);
    });

    it('should tell password is valid when it contains one or more capital letters', () => {
        expect(passwordValidator.validate('aBcD_123')).toBe(true);
    });
});