<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:if test="${not empty employees}">

        <c:forEach items="${employees}" var="employee">
            <div class="col-md-1"></div>
            <div class = "col-md-10 row excursion-info">
                <div class="col-md-3">
                    <img class="img-fluid rounded" src="${pageContext.request.contextPath}/resources/static/img/<c:out value="${employee.image}"/>" >
                </div>
                <div class="col-md-8">
                    <h3><c:out value="${employee.firstname}"/>
                        <c:out value="${employee.lastname}"/></h3>
                    <p><c:out value="${employee.position}"/></p>

                    <c:if test = "${employee.position.toString().equalsIgnoreCase('GUIDE')}">
                        <div class="extendedGuideInfo">
                            <label>From</label>
                            <input id="dateStartSelect-${employee.id}" type="datetime-local" name="dateSelect" style="margin-left: 20px"
                                   min="2000-06-07T00:00" max="2060-06-14T00:00" required>
                            <label style="margin-left: 30px">To</label>
                            <input id="dateFinishSelect-${employee.id}" type="datetime-local" name="dateSelect" style="margin-left: 20px"
                                   min="2000-06-07T00:00" max="2060-06-14T00:00" required>
                            <br>
                            <label id="workTime-${employee.id}">Work time: ---</label>
                            <button id="workTimeSearchButton-${employee.id}" style="float: right" onclick="getWorkTime(this.id)">Get work time</button>
                            <br>
                            <label id="excursionsCount-${employee.id}">Excursions done: ---</label>
                            <button id="excursionsCountButton-${employee.id}" style="float: right" onclick="getExcursionsCount(this.id)">Get count of excursions</button>
                        </div>
                    </c:if>

                </div>
            </div>
            <div class="col-md-1"></div>
        </c:forEach>

    </c:if>
<c:if test="${empty employees}">
        <div class="col-md-1"></div>
        <h2>We're sorry, but no employees found:(</h2>
</c:if>

