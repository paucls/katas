import {PasswordValidator} from "@/password.validator";

describe('Password Validator', () => {

  const passwordValidator = new PasswordValidator();

  describe('password', () => {

    it('should be valid when follows all rules', () => {
      expect(passwordValidator.isValid("aB_34567")).toBe(true);
    });

    it('should be invalid when is less than 8 characters long', () => {
      expect(passwordValidator.isValid("aB_3456")).toBe(false);
    });

    it('should be invalid when does not contain a capital letter', () => {
      expect(passwordValidator.isValid("ab_34567")).toBe(false);
    });

    it('should be invalid when does not contain a lowercase letter', () => {
      expect(passwordValidator.isValid("AB_34567")).toBe(false);
    });

    it('should be invalid when does not contain an underscore', () => {
      expect(passwordValidator.isValid("aB234567")).toBe(false);
    });

  });
});
