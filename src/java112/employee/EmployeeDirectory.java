package java112.employee;

import java.io.*;
import java.sql.*;
import java.util.*;
import java112.utilities.*;

/**
 * This class is for performing searches and adds to the employees table
 */
public class EmployeeDirectory {

    private Properties properties;

    /**
     * Empty constructor
     */
    public EmployeeDirectory() {

    }

    /**
     * Constructor with one Properties parameter
     * @param properties properties to be used for the output
     */
    public EmployeeDirectory(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * Returns the database connection
     * @return the database connection
     */
    private Connection establishConnection() {
        Connection connection = null;
        try {
            Class.forName(properties.getProperty("driver"));
            connection = DriverManager.getConnection(
                    properties.getProperty("url"), "student", "student");
        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }
        return connection;
    }

    /**
     * Adds a new record to the employee table in the database
     * @param fields  Strings representing the fields of an employee record.
     */
    public void addEmployee(String[] fields) {

        Connection connection = establishConnection();

        try {

            Statement statement = connection.createStatement();

            String insertString = "INSERT INTO employees VALUES (0, '" +
                    fields[0] + "', '" + fields[1] + "', '" + fields[2] +
                    "', '" + fields[3] + "', '" + fields[4] + "', '" +
                    fields[5] + "')";

            System.out.println("insertString: " + insertString);

            int rowsAffected = statement.executeUpdate(insertString);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    /**
     * Performs a search on the employees table, depending on the type and term
     * @param searchType    Describes the search type: ID, Last Name,
     *                      or First Name
     * @param searchTerm    Describes the actual ID, last name,
     *                      or first name being searched
     * @return              a Search object with the type and term set
     */
    public Search searchEmployees(String searchType, String searchTerm) {

        Search search = new Search();

        search.setSearchType(searchType);
        search.setSearchTerm(searchTerm);

        if (searchType == "id") {
            searchByID(search);
        } else if (searchType == "lastName") {
            searchByLastName(search);
        } else if (searchType == "firstName") {
            searchByFirstName(search);
        }
    }

    private void searchByID(Search search) {

        Connection connection = establishConnection();

        try {

            Statement statement = connection.createStatement();

            String queryString = "SELECT * FROM employees WHERE employeeID = '"
                    + search.searchTerm;

            System.out.println("insertString: " + insertString);

            int rowsAffected = statement.executeUpdate(insertString);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    private void searchByLastName(Search search) {

        Connection connection = establishConnection();

        try {

            Statement statement = connection.createStatement();

            String queryString = "SELECT * FROM employees WHERE employeeID = '"
                    + search.searchTerm;

            System.out.println("insertString: " + insertString);

            int rowsAffected = statement.executeUpdate(insertString);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    private void searchByFirstName(Search search) {

        Connection connection = establishConnection();

        try {

            Statement statement = connection.createStatement();

            String queryString = "SELECT * FROM employees WHERE employeeID = '"
                    + search.searchTerm;

            System.out.println("insertString: " + insertString);

            int rowsAffected = statement.executeUpdate(insertString);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}