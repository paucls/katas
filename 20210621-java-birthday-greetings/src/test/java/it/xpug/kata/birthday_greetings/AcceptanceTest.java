package it.xpug.kata.birthday_greetings;

import static org.junit.Assert.*;

import it.xpug.kata.birthday_greetings.adapters.EmployeesFileRepository;
import it.xpug.kata.birthday_greetings.application.BirthdayService;
import it.xpug.kata.birthday_greetings.application.MessageSender;
import it.xpug.kata.birthday_greetings.application.XDate;
import org.junit.*;

import com.dumbster.smtp.*;

import java.util.List;

public class AcceptanceTest {

	private static final int NONSTANDARD_PORT = 9999;
	private BirthdayService birthdayService;
	private SimpleSmtpServer mailServer;

	@Before
	public void setUp() throws Exception {
		mailServer = SimpleSmtpServer.start(NONSTANDARD_PORT);
		birthdayService = new BirthdayService(
				new EmployeesFileRepository("employee_data.txt"),
				new MessageSender("localhost", NONSTANDARD_PORT)
		);
	}

	@After
	public void tearDown() throws Exception {
		mailServer.stop();
		Thread.sleep(200);
	}

	@Test
	public void willSendGreetings_whenItsSomebodysBirthday() throws Exception {
		birthdayService.sendGreetings(new XDate("2008/10/08"));

		assertEquals("message not sent?", 1, mailServer.getReceivedEmails().size());
		SmtpMessage message = mailServer.getReceivedEmails().get(0);
		assertEquals("Happy Birthday, dear John!", message.getBody());
		assertEquals("Happy Birthday!", message.getHeaderValue("Subject"));
		List<String> recipients = message.getHeaderValues("To");
		assertEquals(1, recipients.size());
		assertEquals("john.doe@foobar.com", recipients.get(0));
	}

	@Test
	public void willNotSendEmailsWhenNobodysBirthday() throws Exception {
		birthdayService.sendGreetings(new XDate("2008/01/01"));

		assertEquals("what? messages?", 0, mailServer.getReceivedEmails().size());
	}
}
