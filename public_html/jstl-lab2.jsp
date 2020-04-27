<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSTL Lab 2</title>
</head>
<body>
    <ul>
        <c:forEach var="dog" items="${dogsList}">
            <li>${dog}</li>
        </c:forEach>
    </ul>
</body>
</html>