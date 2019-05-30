<<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Exhibits</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/styles/stylesheet.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<c:forEach items="${exhibits}" var="exhibit">
    <div class = "col-md-3" >
        <div class="card">
            <img class="card-img-top"  src="${pageContext.request.contextPath}/static/img/<c:out value="${exhibit.image}"/>" alt="Card image">
            <div class="card-body">
                <h4 class="card-title"><c:out value="${exhibit.name}"/></h4>

                <p class="card-text">
                    Author: <c:out value="${exhibit.author.firstname}"/>
                    <c:out value="${exhibit.author.lastname}"/>
                </p>

                <p class="card-text">Material: <c:out value="${exhibit.material}"/> </p>
                <p class="card-text">Technique: <c:out value="${exhibit.technique}"/></p>
                <p class="card-text">Hall:  <c:out value="${exhibit.hall.name}"/></p>
            </div>

        </div>
    </div>
</c:forEach>
</body>
