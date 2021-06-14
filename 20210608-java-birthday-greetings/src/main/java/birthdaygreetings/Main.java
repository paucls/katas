package birthdaygreetings;

import birthdaygreetings.adapters.in.FileEmployeesReader;
import birthdaygreetings.adapters.out.SmtpEmailServer;

public class Main {
    public static void main(String[] args) {
        BirthdayService service = new BirthdayService(new SmtpEmailServer("localhost", 25), new FileEmployeesReader());
        try {
            service.sendGreetings("employee_data.txt",
                    new OurDate("2008/10/08"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
