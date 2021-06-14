package birthdaygreetings;

import javax.mail.MessagingException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class BirthdayService {

    private EmailSender emailSender;

    public BirthdayService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendGreetings(String fileName, OurDate ourDate) throws IOException, ParseException,
            MessagingException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String str = "";
        str = in.readLine(); // skip header
        while ((str = in.readLine()) != null) {
            String[] employeeData = str.split(", ");
            Employee employee = new Employee(employeeData[1], employeeData[0],
                    employeeData[2], employeeData[3]);
            if (employee.isBirthday(ourDate)) {
                String recipient = employee.getEmail();
                String body = "Happy Birthday, dear %NAME%!".replace("%NAME%",
                        employee.getFirstName());
                String subject = "Happy Birthday!";

                emailSender.sendMessage(subject, body, recipient);
            }
        }
    }
}
