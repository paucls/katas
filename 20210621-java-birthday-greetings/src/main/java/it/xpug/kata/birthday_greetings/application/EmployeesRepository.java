package it.xpug.kata.birthday_greetings.application;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface EmployeesRepository {
    List<Employee> getEmployees() throws IOException, ParseException;
}
