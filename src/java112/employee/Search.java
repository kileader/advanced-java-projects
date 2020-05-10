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

    // The following are self describing javabean methods
    public String getSearchType() {
        return searchType;
    }
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }
    public String getSearchTerm() {
        return searchTerm;
    }
    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }
    public List<Employee> getResults() {
        return results;
    }
    public void setResults(List<Employee> results) {
        this.results = results;
    }
    public boolean isFoundEmployees() {
        return foundEmployees;
    }
    public void setFoundEmployees(boolean foundEmployees) {
        this.foundEmployees = foundEmployees;
    }

    /**
     * Adds an employee object to the list of found employees (results)
     * @param employee
     */
    public void addFoundEmployee(Employee employee) {
        results.add(employee);
    }

}