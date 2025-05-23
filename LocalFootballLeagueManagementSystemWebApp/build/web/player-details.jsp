<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Player Details</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Player Details</h1>
        
        <div class="player-card">
            <div class="player-header">
                <h2>${player.firstName} ${player.lastName}</h2>
                <span class="player-id">ID: ${player.playerId}</span>
            </div>
            
            <div class="player-image">
                <c:choose>
                    <c:when test="${not empty player.profilePicturePath}">
                        <img src="${player.profilePicturePath}" alt="${player.firstName} ${player.lastName}">
                    </c:when>
                    <c:otherwise>
                        <div class="no-image">No Image Available</div>
                    </c:otherwise>
                </c:choose>
            </div>
            
            <div class="player-info">
                <div class="info-row">
                    <span class="label">Team:</span>
                    <span class="value">${player.team.teamName}</span>
                </div>
                
                <div class="info-row">
                    <span class="label">Age:</span>
                    <span class="value">${player.age}</span>
                </div>
                
                <div class="info-row">
                    <span class="label">Position:</span>
                    <span class="value">${player.playingPosition}</span>
                </div>
                
                <div class="info-row">
                    <span class="label">Nationality:</span>
                    <span class="value">${player.nationality}</span>
                </div>
                
                <div class="info-row">
                    <span class="label">Contact:</span>
                    <span class="value">${player.contactNumber}</span>
                </div>
                
                <div class="info-row">
                    <span class="label">Address:</span>
                    <span class="value">${player.address}</span>
                </div>
            </div>
        </div>
        
        <div class="actions">
                <a href="${pageContext.request.contextPath}/UpdatePlayerServlet?playerId=${player.playerId}" class="btn">Edit Player</a>
                <a href="${pageContext.request.contextPath}/DeletePlayerServlet?playerId=${player.playerId}" class="btn-danger">Delete Player</a>
                <a href="${pageContext.request.contextPath}/ListPlayersServlet?teamId=${player.team.teamId}" class="btn">View Team Players</a>
            </div>
        </div>
        
        <div class="navigation">
            <a href="${pageContext.request.contextPath}/ListPlayersServlet" class="btn">Back to Players List</a>
            <a href="${pageContext.request.contextPath}/index.jsp" class="btn">Back to Home</a>
        </div>
    </div>
</body>
</html>