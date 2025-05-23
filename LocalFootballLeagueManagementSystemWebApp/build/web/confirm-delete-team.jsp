<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Confirm Delete Team</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Confirm Delete Team</h1>
        
        <div class="alert warning">
            <p>Are you sure you want to delete the team "${team.teamName}"?</p>
            <p><strong>Warning:</strong> This will also delete all players associated with this team!</p>
        </div>
        
        <form action="${pageContext.request.contextPath}/DeleteTeamServlet" method="post">
            <input type="hidden" name="teamId" value="${team.teamId}">
            <input type="hidden" name="confirmed" value="yes">
            
            <div class="form-group">
                <button type="submit" class="btn-danger">Yes, Delete Team</button>
                <a href="${pageContext.request.contextPath}/ListTeamsServlet" class="btn">Cancel</a>
            </div>
        </form>
    </div>
</body>
</html>