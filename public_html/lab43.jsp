<!DOCTYPE html>
<html>
<head>
    <title>Lab 3</title>
</head>
<body>
<h4>Form for Lab 3</h4>
<form action="/java112/lab43" method="GET">
    <label for="name">Name: </label>
    <input id="name" type="text" name="name" /><br />
    <br /><p>Gender:</p>
    <input type="radio" id="male" name="gender" value="male">
    <label for="male">Male</label><br>
    <input type="radio" id="female" name="gender" value="female">
    <label for="female">Female</label><br>
    <input type="radio" id="non-binary" name="gender" value="non-binary">
    <label for="non-binary">Non-Binary</label><br>
    <br />
    <input type="submit" name="" value="Enter" />
</form>
</body>
</html>