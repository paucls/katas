package birthdaygreetings;

import javax.mail.MessagingException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class BirthdayService {

    private final EmailSender emailSender;

    public BirthdayService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendGreetings(String fileName, OurDate ourDate) throws IOException, ParseException,
            MessagingException {

        EmployeesReader employeesReader = new EmployeesReader();
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
