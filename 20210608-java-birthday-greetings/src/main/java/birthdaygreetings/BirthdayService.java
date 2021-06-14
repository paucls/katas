package birthdaygreetings;

import javax.mail.MessagingException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class BirthdayService {

    private final EmailSender emailSender;

    public BirthdayService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendGreetings(String fileName, OurDate ourDate) throws IOException, ParseException,
            MessagingException {

        List<Employee> employees = new ArrayList<>();

        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String str = "";
        str = in.readLine(); // skip header
        while ((str = in.readLine()) != null) {
            String[] employeeData = str.split(", ");
            Employee employee = new Employee(employeeData[1], employeeData[0],
                    employeeData[2], employeeData[3]);
            employees.add(employee);
        }

        for (Employee employee : employees) {
            if (employee.isBirthday(ourDate)) {
                sendEmailTo(employee);
            }
        }
    }

    private void sendEmailTo(Employee employee) throws MessagingException {
        String body = "Happy Birthday, dear %NAME%!".replace("%NAME%",
                employee.getFirstName());
        String subject = "Happy Birthday!";
        String recipient = employee.getEmail();

        emailSender.sendMessage(subject, body, recipient);
    }
}
