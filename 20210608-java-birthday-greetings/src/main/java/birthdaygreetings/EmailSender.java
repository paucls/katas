package birthdaygreetings;

import javax.mail.MessagingException;

public interface EmailSender {
    void sendMessage(String subject, String body, String recipient) throws MessagingException;
}
