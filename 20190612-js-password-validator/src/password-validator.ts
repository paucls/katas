export class PasswordValidator {
    validate(password) {
        return password.length >= 8 &&
            password.includes('A');
    }
}