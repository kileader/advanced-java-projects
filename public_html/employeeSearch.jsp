<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<c:import url="index-head.jsp" />
<body>
<div id="container">
    <c:import url="index-header.jsp" />
    <div id="main_content_top"></div>
    <div id="main_content">
        <c:import url="employeeSearch-content.jsp" />
        <c:import url="index-menu.jsp" />
        <div id="clear"></div>
    </div>
    <div id="main_content_bottom"></div>
    <c:import url="index-footer.jsp" />
</div>
</body>
</html>
