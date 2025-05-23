<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Teams List</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Teams List</h1>
        
        <div class="actions">
            <a href="add-team.jsp" class="btn">Add New Team</a>
        </div>
        
        <table class="data-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Home Ground</th>
                    <th>Home Jersey</th>
                    <th>Away Jersey</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${teams}" var="team">
                    <tr>
                        <td>${team.teamId}</td>
                        <td>${team.teamName}</td>
                        <td>${team.homeGround}</td>
                        <td>${team.homeJerseyColor}</td>
                        <td>${team.awayJerseyColor}</td>
                        <td class="actions">
                            <a href="${pageContext.request.contextPath}/UpdateTeamServlet?teamId=${team.teamId}" class="btn-small">Edit</a>
                            <a href="${pageContext.request.contextPath}/DeleteTeamServlet?teamId=${team.teamId}" class="btn-small btn-danger">Delete</a>
                            <a href="${pageContext.request.contextPath}/ListPlayersServlet?teamId=${team.teamId}" class="btn-small">View Players</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <c:if test="${empty teams}">
            <p class="message">No teams found.</p>
        </c:if>
        
        <div class="navigation">
            <a href="index.html" class="btn">Back to Home</a>
        </div>
    </div>
</body>
</html>