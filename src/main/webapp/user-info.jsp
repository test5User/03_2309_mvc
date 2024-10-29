<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Info</title>
</head>
<body>
    <c:choose>
        <c:when test="${not empty us}">
            <p>Id: ${us.getId()}</p>
            <p>Fio: ${us.fio}</p>
            <p>Email: ${us.email}</p>
        </c:when>
        <c:otherwise>
            <h1>${mes}</h1>
        </c:otherwise>
    </c:choose>
</body>
</html>
