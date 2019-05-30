<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Authors</title>
</head>
<body>
<c:forEach items="${authors}" var="author">
    <p><c:out value="${author.firstname}"/></p>
    <p><c:out value="${author.lastname}"/></p>
</c:forEach>
</body>
</html>
