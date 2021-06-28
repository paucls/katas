package it.xpug.kata.birthday_greetings.application;

import javax.mail.MessagingException;

public interface MessageSender {
    void sendMessage(String sender, String subject, String body, String recipient) throws MessagingException;
}
