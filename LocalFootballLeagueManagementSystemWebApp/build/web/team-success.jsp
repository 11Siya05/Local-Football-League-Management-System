<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Success</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Success</h1>
        
        <div class="alert success">
            <p>${message}</p>
        </div>
        
        <div class="navigation">
            <a href="${pageContext.request.contextPath}/ListTeamsServlet" class="btn">View All Teams</a>
            <a href="${pageContext.request.contextPath}/index.jsp" class="btn">Back to Home</a>
        </div>
    </div>
</body>
</html>