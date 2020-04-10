<!DOCTYPE html>

<%!

    public void jspInit() {
        ServletContext.setAttribute("foo", "bar");
    }

%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="generator" content="HTML Tidy, see www.w3.org" />
    <title>Unit 3 Lab 6</title>
</head>
<body>
    <h1>Using the ServletContext</h1>
    <%= getAttribute("foo") %>
</body>
</html>
