export class PasswordValidator {
    validate(password) {
        return password.length >= 8 &&
            this.containsCapitalLetter(password) &&
            /[a-z]/.test(password);
    }

    private containsCapitalLetter(password) {
        return /\w*[A-Z]\w*/.test(password);
    }
}