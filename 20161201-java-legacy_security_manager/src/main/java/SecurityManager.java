import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class SecurityManager {

    private final BufferedReader input;
    private final PrintStream output;

    public SecurityManager(BufferedReader buffer, PrintStream output) {
        this.input = buffer;
        this.output = output;
    }

    public void createUser() {
        String username = null;
        String fullName = null;
        String password = null;
        String confirmPassword = null;
        try {
            output.println("Enter a username");
            username = input.readLine();
            output.println("Enter your full name");
            fullName = input.readLine();
            output.println("Enter your password");
            password = input.readLine();
            output.println("Re-enter your password");
            confirmPassword = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!password.equals(confirmPassword)) {
            output.println("The passwords don't match");
            return;
        }

        if (password.length() < 8) {
            output.println("Password must be at least 8 characters in length");
            return;
        }

        // Encrypt the password (just reverse it, should be secure)
        String encryptedPassword = new StringBuilder(password).reverse().toString();

        output.println(
                String.format(
                        "Saving Details for User (%s, %s, %s)\n",
                        username,
                        fullName,
                        encryptedPassword)
        );
    }
}
