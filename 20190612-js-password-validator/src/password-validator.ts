export class PasswordValidator {
    validate(password) {
        return this.hasMinLength(password) &&
            this.containsCapital(password) &&
            this.containsLowercase(password) &&
            this.containsUnderscore(password) &&
            this.containsNumber(password);
    }

    private hasMinLength(password) {
        return password.length >= 8;
    }

    private containsCapital(password) {
        return /[A-Z]/.test(password);
    }

    private containsLowercase(password) {
        return /[a-z]/.test(password);
    }

    private containsUnderscore(password) {
        return password.includes('_');
    }

    private containsNumber(password) {
        return /[0-9]/.test(password);
    }
}