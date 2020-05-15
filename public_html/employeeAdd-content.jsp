<div class="content">
    <h2>
        Add a New Employee
    </h2>
    <form action="/java112/employee-add-action" method="POST">
        <table>
            <tr>
                <td><label for="firstName">First Name: </label></td>
                <td><input id="firstName" type="text" name="firstName" /></td>
            </tr>
            <tr>
                <td><label for="lastName">Last Name: </label></td>
                <td><input id="lastName" type="text" name="lastName" /></td>
            </tr>
            <tr>
                <td><label for="socialSecurity">Social Security: </label></td>
                <td><input id="socialSecurity" type="text" name="socialSecurity" /></td>
            </tr>
            <tr>
                <td><label for="department">Department: </label></td>
                <td><input id="department" type="text" name="department" /></td>
            </tr>
            <tr>
                <td><label for="room">Room: </label></td>
                <td><input id="room" type="text" name="room" /><br /></td>
            </tr>
            <tr>
                <td><label for="phone">Phone: </label></td>
                <td><input id="phone" type="text" name="phone" /></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="" value="Enter" /></td>
            </tr>
        </table>
    </form>
    <h3>${employeeMessage}</h3>
    <c:remove var="employeeMessage" />
</div>