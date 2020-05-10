<div class="content">
    <h2>
        Employee Search
    </h2>
    <form action="/java112/employee-search-results" method="GET">
        <label for="searchTerm">Search Term: </label>
        <input id="searchTerm" type="text" name="searchTerm" /><br />
        <p>Search Type:</p>
        <input type="radio" id="id" name="searchType" value="id">
        <label for="id">ID</label><br>
        <input type="radio" id="lastName" name="searchType" value="lastName">
        <label for="lastName">Last Name</label><br>
        <input type="radio" id="firstName" name="searchType" value="firstName">
        <label for="firstName">First Name</label><br>
        <br />
        <input type="submit" name="" value="Enter" />
    </form>
</div>