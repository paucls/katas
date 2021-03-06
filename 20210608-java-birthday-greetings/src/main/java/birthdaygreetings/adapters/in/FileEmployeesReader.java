package birthdaygreetings.adapters.in;

import birthdaygreetings.Employee;
import birthdaygreetings.EmployeesReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class FileEmployeesReader implements EmployeesReader {
    @Override
    public List<Employee> readEmployees(String fileName) throws IOException, ParseException {
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

        return employees;
    }
}
