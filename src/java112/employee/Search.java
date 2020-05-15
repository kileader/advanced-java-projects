package java112.employee;

import java.util.*;

/**
 * This is a javabean representing an employee search
 */
public class Search {

    /**
     * Describes the search type: ID, Last Name, or First Name
     */
    private String searchType;

    /**
     * Describes the actual ID, last name, or first name being searched
     */
    private String searchTerm;

    /**
     * List of employee objects representing the results of the search
     */
    private List<Employee> results = new ArrayList<Employee>();

    /**
     * Boolean indicating if the search found employees or not
     */
    private boolean foundEmployees;

    /**
     * Empty constructor
     */
    public Search() {

    }

    /**
     * Gets search type.
     *
     * @return the search type
     */
    public String getSearchType() {
        return searchType;
    }

    /**
     * Sets search type.
     *
     * @param searchType
     */
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    /**
     * Gets search term.
     *
     * @return the search term
     */
    public String getSearchTerm() {
        return searchTerm;
    }

    /**
     * Sets search term.
     *
     * @param searchTerm the search term
     */
    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    /**
     * Gets results.
     *
     * @return the results
     */
    public List<Employee> getResults() {
        return results;
    }

    /**
     * Sets results.
     *
     * @param results the results
     */
    public void setResults(List<Employee> results) {
        this.results = results;
    }

    /**
     * Is found employees boolean.
     *
     * @return the boolean
     */
    public boolean isFoundEmployees() {
        return foundEmployees;
    }

    /**
     * Sets found employees.
     *
     * @param foundEmployees the found employees
     */
    public void setFoundEmployees(boolean foundEmployees) {
        this.foundEmployees = foundEmployees;
    }

    /**
     * Adds an employee object to the list of found employees (results)
     *
     * @param employee the employee
     */
    public void addFoundEmployee(Employee employee) {
        results.add(employee);
    }

}