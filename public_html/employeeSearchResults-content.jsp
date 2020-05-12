<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content">
    <h2>
        Employee Search Results
    </h2>
    <c:choose>
        <c:when test="${search.foundEmployees == false}">
            <h3>No Employees Found</h3>
        </c:when>
        <c:otherwise>
            <table>
                <tr>
                    <th>EmployeeID</th><th>First Name</th><th>Last Name</th>
                    <th>Social Security</th><th>Department</th><th>Room</th>
                    <th>Phone</th>
                </tr>
                <c:forEach var="employee" items="${search.results}">
                    <tr>
                        <td>${employee.employeeId}</td>
                        <td>${employee.firstName}</td>
                        <td>${employee.lastName}</td>
                        <td>${employee.socialSecurity}</td>
                        <td>${employee.department}</td>
                        <td>${employee.room}</td>
                        <td>${employee.phone}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</div>