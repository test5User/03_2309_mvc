<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
    <c:set var="number" value="123" scope="page"/>
    <p>Result: ${number + "21"}</p>
    <c:remove var="number"/>
    <p>Result: ${number + "21"}</p>
    <c:if test="${empty number}">
        <p>Not exist or null or empty</p>
    </c:if>
    <c:set var="number" value="3" scope="page"/>
    <c:choose>
        <c:when test="${number == 1}">
            <p>Equals 1</p>
        </c:when>
        <c:when test="${number == 2}">
            <p>Equals 2</p>
        </c:when>
        <c:otherwise>
            <p>Not == 1 or 2</p>
        </c:otherwise>
    </c:choose>

    <c:url var="simpleLink" value="http://yandex.ru"/>
    This is a <a href="${simpleLink}"> Yandex.</a>

    <c:url var="paramlink" value="http://google.com/search">
        <c:param name="q" value="cats"/>
    </c:url>
    This is a <a href="${paramlink}"> cats </a> from google.

    <c:forEach var="cook" items="${cookie}">
        <li>
            <p><c:out value="${cook.value.name}"/></p>
            <p><c:out value="${cook.value.value}"/></p>
        </li>
    </c:forEach>
</body>
</html>
