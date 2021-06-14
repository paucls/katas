package birthdaygreetings;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface EmployeesReader {
    List<Employee> readEmployees(String fileName) throws IOException, ParseException;
}
