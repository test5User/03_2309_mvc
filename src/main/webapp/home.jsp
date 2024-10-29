<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%
    String header = "Hello from JSP";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2><%= header %></h2>
    <p>Today <%= new Date() %></p>
</body>
</html>
