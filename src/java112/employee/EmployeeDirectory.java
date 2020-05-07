package java112.analyzer;

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
     */
//    public void addNewRecord(Search search) {
//        Connection connection = establishConnection();
//
//        Statement statement = connection.createStatement();
//
//        //String queryString =
//    }

    public void Search() {

    }
}