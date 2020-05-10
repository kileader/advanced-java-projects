<div class="content">
    <h2>
        Employee Search Results
    </h2>
    <table>
        <tr><th>EmployeeID</th><th>First Name</th><th>Last Name</th></tr>
        <c:forEach var="employee" items="${employees}">
            <tr></tr>
        </c:forEach>
    </table>
</div>