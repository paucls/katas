class PasswordValidator {
    validate(password) {
        return password.length >= 8;
    }
}

describe('Password Validator', () => {
    it('should tell when a password is valid', () => {
        const passwordValidator = new PasswordValidator();

        const isValid = passwordValidator.validate('Abcd_123');

        expect(isValid).toBe(true)
    });

    it('should tell password is invalid when it has less than 8 characters', () => {
        const passwordValidator = new PasswordValidator();

        const isValid = passwordValidator.validate('Abcd_12');

        expect(isValid).toBe(false)
    });
});