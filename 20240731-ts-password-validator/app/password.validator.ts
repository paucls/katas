export class PasswordValidator {
  isValid(password: string) {
    return this.validateLength(password)
      && this.validateContainsCapital(password)
      && this.validateContainsLowerCase(password)
      && this.validateContainsUnderscore(password);
  }

  private validateContainsUnderscore(password: string) {
    return password.includes("_");
  }

  private validateContainsCapital(password: string) {
    return /[A-Z]/.test(password);
  }

  private validateContainsLowerCase(password: string) {
    return /[a-z]/.test(password);
  }

  private validateLength(password: string) {
    return password.length >= 8;
  }
}
