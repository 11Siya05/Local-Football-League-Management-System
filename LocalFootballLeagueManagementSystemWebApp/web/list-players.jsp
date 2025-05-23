<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Players List</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Players List</h1>
        
        <c:if test="${filterType ne 'none'}">
            <div class="filter-info">
                <p>Showing players filtered by ${filterType}: ${filterValue}</p>
                <a href="${pageContext.request.contextPath}/ListPlayersServlet" class="btn-small">Clear Filter</a>
            </div>
        </c:if>
        
        <div class="actions">
            <a href="add-player.jsp" class="btn">Add New Player</a>
            <a href="search-player.jsp" class="btn">Search Player</a>
        </div>
        
        <table class="data-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Position</th>
                    <th>Nationality</th>
                    <th>Team</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${players}" var="player">
                    <tr>
                        <td>${player.playerId}</td>
                        <td>${player.firstName} ${player.lastName}</td>
                        <td>${player.age}</td>
                        <td>${player.playingPosition}</td>
                        <td>${player.nationality}</td>
                        <td>${player.team.teamName}</td>
                        <td class="actions">
                            <a href="${pageContext.request.contextPath}/UpdatePlayerServlet?playerId=${player.playerId}" class="btn-small">Edit</a>
                            <a href="${pageContext.request.contextPath}/DeletePlayerServlet?playerId=${player.playerId}" class="btn-small btn-danger">Delete</a>
                            <a href="${pageContext.request.contextPath}/player/player-details.jsp?playerId=${player.playerId}" class="btn-small">Details</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <c:if test="${empty players}">
            <p class="message">No players found.</p>
        </c:if>
        
        <div class="filters">
            <h3>Filter Players</h3>
            <div class="filter-options">
                <a href="${pageContext.request.contextPath}/ListPlayersServlet?position=Goalkeeper" class="filter">Goalkeepers</a>
                <a href="${pageContext.request.contextPath}/ListPlayersServlet?position=Defender" class="filter">Defenders</a>
                <a href="${pageContext.request.contextPath}/ListPlayersServlet?position=Midfielder" class="filter">Midfielders</a>
                <a href="${pageContext.request.contextPath}/ListPlayersServlet?position=Forward" class="filter">Forwards</a>
            </div>
        </div>
        
        <div class="navigation">
            <a href="index.html" class="btn">Back to Home</a>
        </div>
    </div>
</body>
</html>