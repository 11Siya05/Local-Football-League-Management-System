<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Error</h1>
        
        <div class="alert error">
            <p>${error}</p>
        </div>
        
        <div class="navigation">
            <a href="${pageContext.request.contextPath}/ListPlayersServlet" class="btn">View All Players</a>
            <a href="${pageContext.request.contextPath}/index.jsp" class="btn">Back to Home</a>
        </div>
    </div>
</body>
</html>