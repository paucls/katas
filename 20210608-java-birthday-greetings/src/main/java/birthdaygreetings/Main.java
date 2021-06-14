package birthdaygreetings;

import birthdaygreetings.adapters.out.SmtpEmailServer;

public class Main {
    public static void main(String[] args) {
        BirthdayService service = new BirthdayService(new SmtpEmailServer("localhost", 25));
        try {
            service.sendGreetings("employee_data.txt",
                    new OurDate("2008/10/08"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
