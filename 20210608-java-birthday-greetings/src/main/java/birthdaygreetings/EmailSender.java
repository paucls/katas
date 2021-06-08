package birthdaygreetings;

public interface EmailSender {
    void sendMessage(String subject, String body, String recipient);
}
