<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
  <c:choose>
    <c:when test="${not empty us}">
        <h1>Users:</h1>
        <c:forEach var="user" items="${us}">
            <p>Id: ${user.id}, FIO: ${user.fio}, Email: ${user.email}</p>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <h1 style="color: red"> ${mes}</h1>
    </c:otherwise>
  </c:choose>
</body>
</html>
