<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: avash
  Date: 5/30/2019
  Time: 1:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<p>test output</p>
    <c:forEach items="${employees}" var="employee">
        <c:out value="${employee.firstname}"/>
        <c:out value="${employee.lastname}"/>
        <c:out value="${employee.position.toString()}"/>
    </c:forEach>
</body>
</html>
