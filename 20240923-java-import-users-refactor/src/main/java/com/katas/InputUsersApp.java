package com.katas;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.*;

public class InputUsersApp {
    private static final String USER_URL = "https://randomuser.me/api/?inc=gender,name,email,location&results=5&seed=a9b25cd955e2037h";

    public void run() throws IOException {
      // Parse CSV file
      ArrayList<String[]> csvUsers = getUsersFromFile();

      // Parse URL content
      ArrayList<String[]> csvUsersFromUrl = getUsersFromUrl();

      /**
       * csvUsers ArrayList<id: number,
       *       email: string
       *       first_name: string
       *       last_name: string>
       */
      csvUsers.addAll(csvUsersFromUrl); // merge arrays

      // Print users
      printInTerminal("*********************************************************************************");
      printInTerminal("* ID\t\t\t* COUNTRY\t\t* NAME\t\t\t\t* EMAIL\t\t\t\t\t\t*");
      printInTerminal("*********************************************************************************");
      for (String[] item: csvUsers) {
        printInTerminal(String.format("* %s\t* %s\t\t* %s\t\t* %s\t*", item[0], item[3], item[2], item[5]));
      }
      printInTerminal("*********************************************************************************");
      printInTerminal(csvUsers.size() + " users in total!");
    }

    protected void printInTerminal(String text) {
      System.out.println(text);
    }

    protected ArrayList<String[]> getUsersFromUrl() throws IOException {
      List<String> a;
      String url = USER_URL;
      String command = "curl -X GET " + url;
      ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
      Process process = processBuilder.start();
      InputStream processInputStream = process.getInputStream();
      Scanner webProvider = new Scanner(processInputStream);
      String result = "";
      while (webProvider.hasNextLine()) {
        result += webProvider.nextLine();
      }
      webProvider.close();
      JSONObject jsonObject = new JSONObject(result);
      JSONArray results = jsonObject.getJSONArray("results");
      a = new ArrayList<>();
      for (int i = 0; i < a.size(); i++) {
        a.add(results.getString(i));
      }

      BigInteger j = new BigInteger("100000000000");
      ArrayList<String[]> b = new ArrayList<>();
      for (int i = 0; i < results.length(); i++) {
        j = j.add(new BigInteger("1"));
        b.add(new String[] {
          j.toString(), // id
          results.getJSONObject(i).getString("gender"),
          results.getJSONObject(i).getJSONObject("name").getString("first") + " " + results.getJSONObject(i).getJSONObject("name").getString("last"),
          results.getJSONObject(i).getJSONObject("location").getString("country"),
          String.valueOf(results.getJSONObject(i).getJSONObject("location").get("postcode")),
          results.getJSONObject(i).getString("email"),
          String.valueOf((new GregorianCalendar()).get(Calendar.YEAR)) // birhtday
        });
      }
      return b;
    }

    protected ArrayList<String[]> getUsersFromFile() {
      ClassLoader classloader = Thread.currentThread().getContextClassLoader();
      InputStream is = classloader.getResourceAsStream("users.csv");
      ArrayList<String[]> csv_providers = new ArrayList<>();
      Scanner csvFile = new Scanner(is);
      while (csvFile.hasNextLine()) {
        String line = csvFile.nextLine();
        // fields: ID, gender, Name ,country, postcode, email, Birthdate
        String[] attributes = line.split(",");
        if (attributes.length == 0) {
          continue;
        }
        csv_providers.add(attributes);
      }
      List<String[]> csvProviers = new ArrayList<>();
      List<String> a = new ArrayList<>();
      for (int i = 0; i < a.size(); i++) {
        a.add(csvProviers.get(i)[0]);
      }
      csv_providers.remove(0); // Remove header column
      return csv_providers;
    }
}
