<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Add New Player</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="container">
            <h1>Add New Player</h1>

            <form action="AddPlayerServlet.do" method="post">
                <div class="form-group">
                    <label for="firstName">First Name:</label>
                    <input type="text" id="firstName" name="firstName" required>
                </div>

                <div class="form-group">
                    <label for="lastName">Last Name:</label>
                    <input type="text" id="lastName" name="lastName" required>
                </div>

                <div class="form-group">
                    <label for="age">Age:</label>
                    <input type="number" id="age" name="age" min="0" max="50" required>
                </div>

                <div class="form-group">
                    <label for="address">Address:</label>
                    <textarea id="address" name="address" rows="3"></textarea>
                </div>

                <div class="form-group">
                    <label for="contactNumber">Contact Number:</label>
                    <input type="text" id="contactNumber" name="contactNumber">
                </div>

                <div class="form-group">
                    <label for="playingPosition">Playing Position:</label>
                    <select id="playingPosition" name="playingPosition">
                        <option value="Goalkeeper">Goalkeeper</option>
                        <option value="Defender">Defender</option>
                        <option value="Midfielder">Midfielder</option>
                        <option value="Forward">Forward</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="nationality">Nationality:</label>
                    <input type="text" id="nationality" name="nationality">
                </div>


                <div class="form-group">
                    <label for="teamId">Team:</label>
                    <select id="teamId" name="teamId" required>
                        <option value="">Select a team</option>
                        <c:forEach items="${teams}" var="team">
                            <option value="${team.teamId}">${team.teamName}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <button type="submit">Add Player</button>
                    <a href="index.html" class="btn">Back to Home</a>
                </div>
            </form>
        </div>
    </body>
</html>