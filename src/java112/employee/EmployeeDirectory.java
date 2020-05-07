package java112.employee;

import java.io.*;
import java.sql.*;
import java.util.*;
import java112.utilities.*;

/**
 * This class is for
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
     *
     * @param args
     */
    private void addEmployee(String[] args) {

        Connection connection = establishConnection();

        try {

            Statement statement = connection.createStatement();

            String insertString = "INSERT INTO employees VALUES (0, '" +
                    args[0] + "', '" + args[1] + "', '" + args[2] + "', '" +
                    args[3] + "', '" + args[4] + "', '" + args[5] + "')";

            System.out.println("insertString: " + insertString);

            int rowsAffected = statement.executeUpdate(insertString);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void Search() {

    }
}