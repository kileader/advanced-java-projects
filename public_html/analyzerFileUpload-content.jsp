<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content">
    <h2>
        Analyzer File Upload
    </h2>
    <form action="/java112/analyzer-file-upload-action" method="POST"
            enctype="multipart/form-data">
        <label for="inputFile"><h3>Select File to Analyze: </h3></label>
        <input type="file" name="inputFile" id="inputFile"><br /><br />
        <input type="submit" value="Upload" name="submit">
    </form>
    <h3>${fileMessage}</h3>
    <c:remove var="fileMessage" />
</div>