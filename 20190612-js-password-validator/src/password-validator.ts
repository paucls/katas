export class PasswordValidator {
    validate(password) {
        return password.length >= 8 &&
            /\w*[A-Z]\w*/.test(password);
    }
}