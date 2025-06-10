package com.pluralsight;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

       Connection connection = null;
       PreparedStatement preparedStatement = null;
       ResultSet results = null;

        try {

            if (args.length != 2) {
            System.out.println(
                    "Application needs two arguments to run: " +
                            "java com.pluralsight.UsingDriverManager <username> <password>");
            System.exit(1);
        }
// get the user name and password from the command line args
        String username = args[0];
        String password = args[1];

        // uses eager loading to load the driver into memory
        // if the dependency has not been added the application
        // will fail here


            Scanner scanner = new Scanner(System.in);

            System.out.println("Please enter a last name to search");
            String lastNameToSearch = scanner.nextLine();

            Class.forName("com.mysql.cj.jdbc.Driver");


            // use the driver to create a connection
            connection = DriverManager. getConnection(
                    "jdbc:mysql://localhost:3306/sakila", "root", "yearup24");


            String query = """
                    SELECT first_name, last_name
                    FROM customer
                    WHERE last_name LIKE ?
                    ORDER BY first_name
                    """;

             preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, lastNameToSearch);

           results = preparedStatement.executeQuery();

            while(results.next()){

//                String firstName = results.getString(1);
//                String lastName = results.getString(2);

                String firstName = results.getString("first_name");
                String lastName = results.getString("last_name");


                System.out.println("First name: " + firstName );
                System.out.println("Last name: " + lastName);
                System.out.println("==============================");

            }



        } catch (Exception e) {
            System.out.println("An error has occured");
            e.printStackTrace();
        } finally {

            if (results != null){

                try {
                    results.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

