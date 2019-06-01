<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

        <div class="col-md-1"></div>
        <div class="col-md-11">
            <label>Excursions count: <c:out value="${excursions.size()}"/></label>
        </div>
        <c:if test="${not empty excursions}">
            <c:forEach items="${excursions}" var="excursion">
                <div class="col-md-1"></div>
                <div class = "col-md-10 row excursion-info">
                    <div class="col-md-4">
                        <h3><c:out value="${excursion.name}"/></h3>
                    </div>
                    <div class="col-md-8">
                        <p>Excursion start: <c:out value="${excursion.start}"/></p>
                        <p>Excursion duration: <c:out value="${excursion.duration}"/> min</p>
                        <p>Guide: <c:out value="${excursion.employee.firstname}"/>
                            <c:out value="${excursion.employee.lastname}"/>
                        </p>
                    </div>
                </div>
                <div class="col-md-1"></div>
            </c:forEach>
        </c:if>
        <c:if test="${empty excursions}">
            <div class="col-md-1"></div>
            <h2>We're sorry, but no excursions found:(</h2>
        </c:if>
