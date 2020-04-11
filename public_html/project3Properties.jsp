<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="index-head.jsp"%>
<body>
<div id="container">
    <%@ include file="index-header.jsp"%>
    <div id="main_content_top"></div>
    <div id="main_content">
        <div class="content">
            <h2>Project 3 Properties</h2>
            <table>
                <tr><th>Property</th><th>Value</th></tr>
                <tr>
                    <td>author</td>
                    <td>${project3Properties.author}</td>
                </tr>
                <tr>
                    <td>author.email.address</td>
                    <td>${project3Properties["author.email.address"]}</td>
                </tr>
                <tr>
                    <td>course.title</td>
                    <td>${project3Properties["course.title"]}</td>
                </tr>
                <tr>
                    <td>course.meeting.times</td>
                    <td>${project3Properties["course.meeting.times"]}</td>
                </tr>
                <tr>
                    <td>instructor</td>
                    <td>${project3Properties.instructor}</td>
                </tr>
                <tr>
                    <td>project.description</td>
                    <td>${project3Properties["project.description"]}</td>
                </tr>
            </table>
        </div>
        <%@ include file="index-menu.jsp"%>
        <div id="clear"></div>
    </div>
    <div id="main_content_bottom"></div>
    <%@ include file="index-footer.jsp"%>
</div>
</body>
</html>
