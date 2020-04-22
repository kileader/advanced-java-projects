package java112.project4;

import java.io.*;
import java.sql.*;

/**
 *
 * @author Kevin Leader
 */
public class JDBCInsertEmployee {

    public void runInsert(String[] args) {

        Connection connection = null;
        Statement statement = null;
        int rowsAffected;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/student", "student", "student");

            statement = connection.createStatement();

            String insertString = "INSERT INTO employees VALUES (0, '" +
                    args[0] + "', '" + args[1] + "', '" + args[2] + "', '" +
                    args[3] + "', '" + args[4] + "', '" + args[5] + "')";

            System.out.println("insertString: " + insertString);

            rowsAffected = statement.executeUpdate(insertString);

//            System.out.println();

//            while (resultSet.next()) {
//                String employeeId = resultSet.getString("emp_id");
//                String firstName = resultSet.getString("first_name");
//                String lastName = resultSet.getString("last_name");
//                System.out.println(" Row: " + employeeId + " "
//                        + firstName + " " + lastName);
//            }

        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
//                if (resultSet != null) {
//                    resultSet.close();
//                }

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
    }

    /**
     * The main method that executes an insert statement. It checks if the
     * command line has 6 arguments then runs the insert if true.
     * @param  args  The command line arguments
     */
    public static void main(String[] args) {
        if (args.length != 6) {
            System.out.println("Please only input six arguments "
                    + "to the command line.");
            return;
        } else {
            JDBCInsertEmployee insert = new JDBCInsertEmployee();

            insert.runInsert(args);
        }
    }
}