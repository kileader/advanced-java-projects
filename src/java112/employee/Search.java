package java112.employee;

import java.util.*;

/**
 * This is a javabean representing an employee search
 */
public class Search {

    private String searchType;
    private String searchTerm;
    private List<String> results;
    private boolean foundEmployees;

    public Search() {

    }

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

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }

    public boolean isFoundEmployees() {
        return foundEmployees;
    }

    public void setFoundEmployees(boolean foundEmployees) {
        this.foundEmployees = foundEmployees;
    }

    public void addFoundEmployee(Employee employee) {

    }

}