export class PasswordValidator {
    validate(password) {
        return password.length >= 8 &&
            this.containsCapital(password) &&
            this.containsLowercase(password) &&
            password.includes('_');
    }

    private containsCapital(password) {
        return /[A-Z]/.test(password);
    }

    private containsLowercase(password) {
        return /[a-z]/.test(password);
    }
}