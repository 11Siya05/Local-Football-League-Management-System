<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Confirm Delete Player</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Confirm Delete Player</h1>
        
        <div class="alert warning">
            <p>Are you sure you want to delete the player "${player.firstName} ${player.lastName}"?</p>
        </div>
        
        <form action="${pageContext.request.contextPath}/DeletePlayerServlet" method="post">
            <input type="hidden" name="playerId" value="${player.playerId}">
            <input type="hidden" name="confirmed" value="yes">
            
            <div class="form-group">
                <button type="submit" class="btn-danger">Yes, Delete Player</button>
                <a href="${pageContext.request.contextPath}/ListPlayersServlet" class="btn">Cancel</a>
            </div>
        </form>
    </div>
</body>
</html>