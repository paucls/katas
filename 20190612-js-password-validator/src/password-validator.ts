export class PasswordValidator {
    validate(password) {
        return this.hasMinLength(password) &&
            this.containsCapital(password) &&
            this.containsLowercase(password) &&
            this.containsUnderscore(password);
    }

    private containsUnderscore(password) {
        return password.includes('_');
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
}