<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title><tiles:getAsString name ="title"/></title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <!-- styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/styles/stylesheet.css">
</head>
<body>

<div class="bg container-fluid">
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="filterBar"/>

    <div id="main-div" class="row container-fluid main-container">
        <tiles:insertAttribute name="content" />
    </div>

    <tiles:insertAttribute name="footer" />

</div>
</body>

<script src='${pageContext.request.contextPath}<tiles:getAsString name="script"/>'></script>

</html>