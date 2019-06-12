class PasswordValidator {
    validate(password: string) {
        return true;
    }
}

describe('Password Validator', () => {
    it('should tell when a password is valid', () => {
        const passwordValidator = new PasswordValidator();

        const isValid = passwordValidator.validate('Abcd_123');

        expect(isValid).toBe(true)
    });
});