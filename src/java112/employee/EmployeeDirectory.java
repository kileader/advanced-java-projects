package java112.employee;

import java.io.*;
import java.util.*;
import java.sql.*;

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
     * @param properties    properties to be used for the output
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
                    properties.getProperty("url"),
                    properties.getProperty("username"),
                    properties.getProperty("password"));
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
     * @param firstName
     * @param lastName
     * @param socialSecurity
     * @param department
     * @param room
     * @param phone
     * @return a message to the user
     */
    public String addEmployee(String firstName, String lastName,
                              String socialSecurity, String department,
                              String room, String phone) {

        // Define variables
        Connection connection = establishConnection();
        Statement statement = null;
        String insertString = "";
        int rowsAffected = 0;
        String message;

        // Check if all the fields were filled
        if (firstName == null || lastName == null || socialSecurity == null ||
                department == null || room == null || phone == null) {
            message = "Please fill out the whole form.";
        } else {
            // Attempt to execute the insert
            try {
                statement = connection.createStatement();

                insertString = "INSERT INTO employees VALUES (0, '" +
                        firstName + "', '" + lastName + "', '" +
                        socialSecurity + "', '" + department + "', '" +
                        room + "', '" + phone + "')";

                rowsAffected = statement.executeUpdate(insertString);

            } catch (SQLException sqlException) {
                //system out
                sqlException.printStackTrace();
            } finally {
                try {
                    if (statement != null) {
                        statement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            // Check if the insert worked
            if (rowsAffected == 0) {
                message = "SQL Insert Failed";
            } else {
                message = "Successfully added employee with : " + insertString;
            }
        }
        // Send a message to user
        return message;
    }

    /**
     * Redirects a search on the employees table, depending on the type and term
     * @param searchType    Describes the search type: ID, Last Name,
     *                      or First Name
     * @param searchTerm    Describes the actual ID, last name,
     *                      or first name being searched
     * @return              a Search object with all values set
     */
    public Search searchEmployees(String searchType, String searchTerm) {

        // Creating search object
        Search search = new Search();

        // Check if the form was filled
        if (searchType != null && searchTerm != null) {

            // Seting the type and term in the search object
            search.setSearchType(searchType);
            search.setSearchTerm(searchTerm);

            // Run the appropriate search function based on the type
            if (searchType.equals("id")) {
                return searchById(search);
            } else if (searchType.equals("lastName")) {
                return searchByLastName(search);
            } else if (searchType.equals("firstName")) {
                return searchByFirstName(search);
            }
        } else {
            // If the form wasn't filled, say no employees were found
            search.setFoundEmployees(false);
        }
        return search;
    }

    /**
     * Creates a queryString for emp_id and calls function to executes it.
     * @param search        a Search object with type and term set
     * @return              a Search object with all values set
     */
    private Search searchById(Search search) {
        String queryString = "SELECT * FROM employees WHERE emp_id = "
                + search.getSearchTerm();
        return searchByQuery(queryString, search);
    }

    /**
     * Creates a queryString for last_name and calls function to execute it
     * @param search        a Search object with type and term set
     * @return              a Search object with all values set
     */
    private Search searchByLastName(Search search) {
        String queryString = "SELECT * FROM employees WHERE last_name like '%"
                + search.getSearchTerm() + "%'";
        return searchByQuery(queryString, search);
    }

    /**
     * Creates a queryString for first_name and calls function to execute it
     * @param search        a Search object with type and term set
     * @return              a Search object with all values set
     */
    private Search searchByFirstName(Search search) {
        String queryString = "SELECT * FROM employees WHERE first_name like '%"
                + search.getSearchTerm() + "%'";
        return searchByQuery(queryString, search);
    }

    /**
     * Searches the employees table based on the query
     * @param queryString   query string that changes depending on search type
     * @param search        a Search object with the type and term set
     * @return              a Search object with all values set
     */
    private Search searchByQuery(String queryString, Search search) {

        // Defining connection
        Connection connection = establishConnection();

        // Declaring variables
        ResultSet resultSet = null;
        Statement statement = null;

        // Trying to execute sql select by emp_id
        try {
            statement = connection.createStatement();

            resultSet = statement.executeQuery(queryString);

            // If there are no results, set foundEmployees to false
            if (!resultSet.next()) {
                search.setFoundEmployees(false);
            } else {
                // Point back to the start of the resultSet
                resultSet.beforeFirst();

                // Add each employee to results list in search
                while (resultSet.next()) {

                    // Create new Employee object
                    Employee employee = new Employee();

                    // Set each instance variable in Employee from resultSet
                    employee.setEmployeeId(resultSet.getString("emp_id"));
                    employee.setFirstName(resultSet.getString("first_name"));
                    employee.setLastName(resultSet.getString("last_name"));
                    employee.setSocialSecurity(resultSet.getString("ssn"));
                    employee.setDepartment(resultSet.getString("dept"));
                    employee.setRoom(resultSet.getString("room"));
                    employee.setPhone(resultSet.getString("phone"));

                    // Add the found employee to the results list in search
                    search.addFoundEmployee(employee);
                }

                // Since there were results, set foundEmployees to true
                search.setFoundEmployees(true);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        // Return the completed search object
        return search;
    }
}