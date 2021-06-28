package it.xpug.kata.birthday_greetings.application;

import it.xpug.kata.birthday_greetings.adapters.EmployeesFileRepository;

import java.io.*;
import java.text.ParseException;

import javax.mail.*;

public class Main {

	public static void main(String[] args) throws IOException, ParseException, MessagingException {
		BirthdayService service = new BirthdayService(
				new EmployeesFileRepository("employee_data.txt"),
				new MessageSender("localhost", 25)
		);
		service.sendGreetings(new XDate());
	}

}
