using Xunit;

namespace KataPasswordValidator.Tests
{
    public class PasswordValidatorTest
    {
        readonly PasswordValidator validator = new PasswordValidator();

        [Fact]
        public void password_must_have_more_than_8_characters()
        {
            Assert.True(validator.IsValid("Abcd_1234"));
            Assert.False(validator.IsValid("Abcd_123"));
        }

        [Fact]
        public void password_must_have_a_capital_letter()
        {
            Assert.True(validator.IsValid("Abcd_1234"));
            Assert.False(validator.IsValid("abcd_1234"));
        }

        [Fact]
        public void password_must_contain_a_lower_case_letter()
        {
            Assert.True(validator.IsValid("Abcd_1234"));
            Assert.False(validator.IsValid("ABCD_1234"));
        }

        [Fact]
        public void password_must_contain_a_number()
        {
            Assert.True(validator.IsValid("Abcd_1234"));
            Assert.False(validator.IsValid("Abcd_efgh"));
        }

        [Fact]
        public void password_must_contain_an_underscore()
        {
            Assert.True(validator.IsValid("Abcd_1234"));
            Assert.False(validator.IsValid("Abcd12345"));
        }
    }
}