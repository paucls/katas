package it.xpug.kata.birthday_greetings;

import java.io.*;
import java.text.ParseException;

import javax.mail.*;

public class Main {

	public static void main(String[] args) throws IOException, ParseException, MessagingException {
		BirthdayService service = new BirthdayService(new EmployeesFileRepository("employee_data.txt"));
		service.sendGreetings(new XDate(), "localhost", 25);
	}

}
