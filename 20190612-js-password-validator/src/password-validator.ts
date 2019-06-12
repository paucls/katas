export class PasswordValidator {
    validate(password) {
        return password.length >= 8 &&
            this.containsCapitalLetter(password);
    }

    private containsCapitalLetter(password) {
        return /\w*[A-Z]\w*/.test(password);
    }
}