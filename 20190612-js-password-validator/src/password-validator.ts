export class PasswordValidator {
    validate(password) {
        return password.length >= 8;
    }
}