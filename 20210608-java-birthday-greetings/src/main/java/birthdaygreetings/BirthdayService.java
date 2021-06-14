package birthdaygreetings;

import javax.mail.MessagingException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class BirthdayService {

    private final EmailSender emailSender;
    private final EmployeesReader employeesReader;

    public BirthdayService(EmailSender emailSender, EmployeesReader employeesReader) {
        this.emailSender = emailSender;
        this.employeesReader = employeesReader;
    }

    public void sendGreetings(String fileName, OurDate ourDate) throws IOException, ParseException,
            MessagingException {

        List<Employee> employees = employeesReader.readEmployees(fileName);

        for (Employee employee : employees) {
            if (employee.isBirthday(ourDate)) {
                sendGreetingTo(employee);
            }
        }
    }

    private void sendGreetingTo(Employee employee) throws MessagingException {
        String body = "Happy Birthday, dear %NAME%!".replace("%NAME%",
                employee.getFirstName());
        String subject = "Happy Birthday!";
        String recipient = employee.getEmail();

        emailSender.sendMessage(subject, body, recipient);
    }
}
