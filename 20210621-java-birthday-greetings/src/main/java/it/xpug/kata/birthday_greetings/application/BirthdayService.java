package it.xpug.kata.birthday_greetings.application;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.mail.MessagingException;

public class BirthdayService {

	private final EmployeesRepository employeesRepository;
	private final MessageSender messageSender;

	public BirthdayService(EmployeesRepository employeesRepository, MessageSender messageSender) {
		this.employeesRepository = employeesRepository;
		this.messageSender = messageSender;
	}

	public void sendGreetings(XDate xDate, String smtpHost, int smtpPort) throws IOException, ParseException, MessagingException {
		List<Employee> employees = employeesRepository.getEmployees();

		for (Employee employee : employees) {
			if (employee.isBirthday(xDate)) {
				sendGreetingToEmployee(smtpHost, smtpPort, employee);
			}
		}
	}

	private void sendGreetingToEmployee(String smtpHost, int smtpPort, Employee employee) throws MessagingException {
		String recipient = employee.getEmail();
		String body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.getFirstName());
		String subject = "Happy Birthday!";
		messageSender.sendMessage(smtpHost, smtpPort, "sender@here.com", subject, body, recipient);
	}

}
