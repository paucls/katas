package com.katas;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

public class InputUsersAppTest {

    @Test public void
    should_print_when_0_users() throws IOException {
        final List<String> printed = new ArrayList<>();
        InputUsersApp app = new InputUsersApp() {

            @Override
            protected ArrayList<String[]> getUsersFromUrl() throws IOException {
                return new ArrayList<>();
            }

            @Override
            protected ArrayList<String[]> getUsersFromFile() {
                return new ArrayList<>();
            }

            @Override
            protected void printInTerminal(String text) {
                printed.add(text);
            }
        };

        app.run();

        assertThat(printed.toString()).isEqualTo("[*********************************************************************************, * ID\t\t\t* COUNTRY\t\t* NAME\t\t\t\t* EMAIL\t\t\t\t\t\t*, *********************************************************************************, *********************************************************************************, 0 users in total!]");
    }

    @Test public void
    should_print_when_1_user() throws IOException {
        final List<String> printed = new ArrayList<>();
        InputUsersApp app = new InputUsersApp() {

            @Override
            protected ArrayList<String[]> getUsersFromUrl() {
                String[] user1 = new String[]{"200189617246","male","Lukas","Schmidt","Germany","10780","lukas.shmidt@example.com","1997-02-19T04:10:00.000Z"};
                ArrayList<String[]> users = new ArrayList<>();
                users.add(user1);
                return users;
            }

            @Override
            protected ArrayList<String[]> getUsersFromFile() {
                return new ArrayList<>();
            }

            @Override
            protected void printInTerminal(String text) {
                printed.add(text);
            }
        };

        app.run();

        assertThat(printed.toString()).isEqualTo("[*********************************************************************************, * ID\t\t\t* COUNTRY\t\t* NAME\t\t\t\t* EMAIL\t\t\t\t\t\t*, *********************************************************************************, * 200189617246\t* Schmidt\t\t* Lukas\t\t* 10780\t*, *********************************************************************************, 1 users in total!]");
    }

}
