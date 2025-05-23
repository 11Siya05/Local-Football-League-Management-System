<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Add New Team</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="container">
            <h1>Add New Team</h1>

            <form action="AddTeamServlet.do" method="post">
                <div class="form-group">
                    <label for="teamName">Team Name:</label>
                    <input type="text" id="teamName" name="teamName" required>
                </div>


                <div class="form-group">
                    <label for="homeGround">Home Ground:</label>
                    <input type="text" id="homeGround" name="homeGround">
                </div>

                <div class="form-group">
                    <label for="homeJerseyColor">Home Jersey Color:</label>
                    <input type="text" id="homeJerseyColor" name="homeJerseyColor">
                </div>

                <div class="form-group">
                    <label for="awayJerseyColor">Away Jersey Color:</label>
                    <input type="text" id="awayJerseyColor" name="awayJerseyColor">
                </div>

                <div class="form-group">
                    <button type="submit">Add Team</button>
                    <a href="index.html" class="btn">Back to Home</a>
                </div>
            </form>
        </div>
    </body>
</html>