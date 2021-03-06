<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:forEach items="${exhibits}" var="exhibit">
    <div class = "col-md-3" >
        <div class="card">
            <img class="card-img-top"  src="${pageContext.request.contextPath}/resources/static/img/<c:out value="${exhibit.image}"/>" alt="Card image">
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
