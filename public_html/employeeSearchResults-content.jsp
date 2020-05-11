<div class="content">
    <p>${search.getSearchType()}, ${search.getSearchTerm()}</p>
    <h2>
        Employee Search Results
    </h2>
    <table>
        <tr>
            <th>EmployeeID</th><th>First Name</th><th>Last Name</th>
            <th>Social Security</th><th>Department</th><th>Room</th>
            <th>Phone</th>
        </tr>
        <c:forEach var="employee" items="${search.getResults()}">
            <tr>${employee}</tr>
        </c:forEach>
    </table>
</div>