package birthdaygreetings.test;

import birthdaygreetings.BirthdayService;
import birthdaygreetings.EmailSender;
import birthdaygreetings.OurDate;
import birthdaygreetings.adapters.out.SmtpEmailServer;
import org.junit.Before;
import org.junit.Test;

import javax.mail.Message;
import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AcceptanceTest {

    private List<Message> messagesSent;
    private EmailSender emailSenderMock;
    private BirthdayService service;

    @Before
    public void setUp() {
        messagesSent = new ArrayList<Message>();

        emailSenderMock = new SmtpEmailServer("xxx", 123) {
            @Override
            protected void sendMessage(Message msg) throws MessagingException {
                messagesSent.add(msg);
            }
        };

        service = new BirthdayService(emailSenderMock);
    }

    @Test
    public void baseScenario() throws Exception {

        service.sendGreetings("src/test/resources/employee_data.txt",
                new OurDate("2008/10/08"));

        assertEquals("message not sent?", 1, messagesSent.size());
        Message message = messagesSent.get(0);
        assertEquals("Happy Birthday, dear John!", message.getContent());
        assertEquals("Happy Birthday!", message.getSubject());
        assertEquals(1, message.getAllRecipients().length);
        assertEquals("john.doe@foobar.com",
                message.getAllRecipients()[0].toString());
    }

    @Test
    public void willNotSendEmailsWhenNobodysBirthday() throws Exception {
        service.sendGreetings("src/test/resources/employee_data.txt",
                new OurDate("2008/01/01"));

        assertEquals("what? messages?", 0, messagesSent.size());
    }
}
