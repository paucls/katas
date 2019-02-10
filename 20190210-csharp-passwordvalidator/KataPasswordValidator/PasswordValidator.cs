using System.Text.RegularExpressions;

namespace KataPasswordValidator
{
    public class PasswordValidator
    {
        private const int MinLength = 9;

        public bool IsValid(string password)
        {
            return HasValidLength(password)
                   && ContainsCapitalLetter(password)
                   && ContainsLowercaseLetter(password)
                   && ContainsNumber(password)
                   && ContainsUnderscore(password);
        }

        private bool HasValidLength(string password)
        {
            return password.Length >= MinLength;
        }

        private bool ContainsCapitalLetter(string password)
        {
            return Regex.IsMatch(password, "[A-Z]");
        }

        private bool ContainsLowercaseLetter(string password)
        {
            return Regex.IsMatch(password, "[a-z]");
        }

        private static bool ContainsNumber(string password)
        {
            return Regex.IsMatch(password, "\\d");
        }

        private static bool ContainsUnderscore(string password)
        {
            return Regex.IsMatch(password, "_");
        }
    }
}