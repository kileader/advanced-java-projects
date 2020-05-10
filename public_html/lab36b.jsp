<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="generator" content="HTML Tidy, see www.w3.org" />
    <title>Unit 3 Lab 6 part B</title>
</head>
<body>
<h1>Using the ServletContext part B</h1>
<h2>Coding</h2>
<p>
    In the results section of this JSP page, I use a JSP expression section
    to call the attribute I set in the first part of this lab. I have to use a
    semicolon, use out.println(), and access the first page before this one.
</p>
<h2>Result</h2>
<p>
    <%
        out.println(application.getAttribute("foo"));
    %>
</p>
</body>
</html>