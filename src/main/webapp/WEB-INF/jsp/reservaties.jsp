<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="partials/header.jsp">
    <jsp:param name="title" value="Reservaties"/>
</jsp:include>

<h1>Reservaties</h1>

<div class="table-responsive">
    <table class="table table-hover table-bordered">
        <thead>
            <tr>
                <th>Id</th>
                <th>Ophaalmoment</th>
                <th>Indienmoment</th>
                <th>Gereserveerd op</th>
                <th>Status</th>
            </tr>
        </thead>

        <c:forEach var="r" items="${reservaties}">
            <tr>
                <td>${r.id}</td>
                <td><fmt:formatDate pattern="dd-MM-yyyy" value="${r.ophaalmoment}" /></td>
                <td><fmt:formatDate pattern="dd-MM-yyyy" value="${r.indienmoment}" /></td>
                <td><fmt:formatDate pattern="dd-MM-yyyy" value="${r.reservatiemoment}" /></td>
                <td>
                    <c:choose>
                        <c:when test="${r.opgehaald == true}">
                            Opgehaald
                        </c:when>    
                        <c:otherwise>
                            Niet opgehaald
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<jsp:include page="partials/footer.jsp" />
