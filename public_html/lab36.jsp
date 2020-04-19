<!DOCTYPE html>
<%!
    public void jspInit() {
        ServletContext context = getServletConfig().getServletContext();
        context.setAttribute("foo", "bar");
    }
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="generator" content="HTML Tidy, see www.w3.org" />
    <title>Unit 3 Lab 6</title>
</head>
<body>
    <h1>Using the ServletContext</h1>
    <h2>Coding</h2>
    <p>
        This jsp page contains a JSP declaration section with jspInit(). A
        context object is created then an attribute named "foo" is set as "bar".
        Towards the end, a JSP expression is used to get the attribute value.
    </p>
    <h2>Result</h2>
    <p><%= application.getAttribute("foo") %></p>
</body>
</html>
