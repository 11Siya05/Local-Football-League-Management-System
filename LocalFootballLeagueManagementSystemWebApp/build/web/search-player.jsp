<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Player</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Search Player</h1>
        
        <form action="${pageContext.request.contextPath}/SearchPlayerServlet" method="post">
            <div class="form-group">
                <label for="playerId">Player ID:</label>
                <input type="number" id="playerId" name="playerId" required>
            </div>
            
            <div class="form-group">
                <button type="submit">Search</button>
                <a href="${pageContext.request.contextPath}/ListPlayersServlet" class="btn">Back to Players</a>
            </div>
        </form>
    </div>
</body>
</html>