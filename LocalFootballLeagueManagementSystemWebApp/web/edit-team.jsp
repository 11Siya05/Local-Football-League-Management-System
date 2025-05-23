<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Team</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Edit Team</h1>
        
        <form action="${pageContext.request.contextPath}/UpdateTeamServlet" method="post">
            <input type="hidden" name="teamId" value="${team.teamId}">
            
            <div class="form-group">
                <label for="teamName">Team Name:</label>
                <input type="text" id="teamName" name="teamName" value="${team.teamName}" required>
            </div>
            
            <div class="form-group">
                <label for="logoPath">Logo Path:</label>
                <input type="text" id="logoPath" name="logoPath" value="${team.logoPath}">
            </div>
            
            <div class="form-group">
                <label for="homeGround">Home Ground:</label>
                <input type="text" id="homeGround" name="homeGround" value="${team.homeGround}">
            </div>
            
            <div class="form-group">
                <label for="homeJerseyColor">Home Jersey Color:</label>
                <input type="text" id="homeJerseyColor" name="homeJerseyColor" value="${team.homeJerseyColor}">
            </div>
            
            <div class="form-group">
                <label for="awayJerseyColor">Away Jersey Color:</label>
                <input type="text" id="awayJerseyColor" name="awayJerseyColor" value="${team.awayJerseyColor}">
            </div>
            
            <div class="form-group">
                <button type="submit">Update Team</button>
                <a href="${pageContext.request.contextPath}/ListTeamsServlet" class="btn">Cancel</a>
            </div>
        </form>
    </div>
</body>
</html>