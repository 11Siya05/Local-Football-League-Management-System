<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Player</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Edit Player</h1>
        
        <form action="${pageContext.request.contextPath}/UpdatePlayerServlet" method="post">
            <input type="hidden" name="playerId" value="${player.playerId}">
            
            <div class="form-group">
                <label for="firstName">First Name:</label>
                <input type="text" id="firstName" name="firstName" value="${player.firstName}" required>
            </div>
            
            <div class="form-group">
                <label for="lastName">Last Name:</label>
                <input type="text" id="lastName" name="lastName" value="${player.lastName}" required>
            </div>
            
            <div class="form-group">
                <label for="age">Age:</label>
                <input type="number" id="age" name="age" min="16" max="50" value="${player.age}" required>
            </div>
            
            <div class="form-group">
                <label for="address">Address:</label>
                <textarea id="address" name="address" rows="3">${player.address}</textarea>
            </div>
            
            <div class="form-group">
                <label for="contactNumber">Contact Number:</label>
                <input type="text" id="contactNumber" name="contactNumber" value="${player.contactNumber}">
            </div>
            
            <div class="form-group">
                <label for="playingPosition">Playing Position:</label>
                <select id="playingPosition" name="playingPosition">
                    <option value="Goalkeeper" ${player.playingPosition eq 'Goalkeeper' ? 'selected' : ''}>Goalkeeper</option>
                    <option value="Defender" ${player.playingPosition eq 'Defender' ? 'selected' : ''}>Defender</option>
                    <option value="Midfielder" ${player.playingPosition eq 'Midfielder' ? 'selected' : ''}>Midfielder</option>
                    <option value="Forward" ${player.playingPosition eq 'Forward' ? 'selected' : ''}>Forward</option>
                </select>
            </div>
            
            <div class="form-group">
                <label for="nationality">Nationality:</label>
                <input type="text" id="nationality" name="nationality" value="${player.nationality}">
            </div>
            
            <div class="form-group">
                <label for="profilePicturePath">Profile Picture Path:</label>
                <input type="text" id="profilePicturePath" name="profilePicturePath" value="${player.profilePicturePath}">
            </div>
            
            <div class="form-group">
                <label for="teamId">Team:</label>
                <select id="teamId" name="teamId" required>
                    <c:forEach items="${teams}" var="team">
                        <option value="${team.teamId}" ${player.team.teamId eq team.teamId ? 'selected' : ''}>${team.teamName}</option>
                    </c:forEach>
                </select>
            </div>
            
            <div class="form-group">
                <button type="submit">Update Player</button>
                <a href="${pageContext.request.contextPath}/ListPlayersServlet" class="btn">Cancel</a>
            </div>
        </form>
    </div>
</body>
</html>