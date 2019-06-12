class PasswordValidator {
    validate(password: string) {
        if (password.length < 8) return false;
        return true;
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