<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="partials/header.jsp">
    <jsp:param name="title" value="Reservaties"/>
</jsp:include>

<a href="../filter" class="gaterugknop btn btn-primary">Ga terug naar lijst kiezen</a>

<h1>Reservaties</h1>
<p>${username}</p>

<div class="table-responsive">
    <table class="table table-hover table-bordered">
        <thead>
            <tr>
                <th>Id</th>
                <th>Gebruiker</th>
                <th>Ophaalmoment</th>
                <th>Indienmoment</th>
                <th>Gereserveerd op</th>
                <th>Status</th>
                <th>Materialen</th>
            </tr>
        </thead>

        <c:forEach var="r" items="${reservaties}">
            <tr>
                <td>${r.id}</td>
                <td>${r.lener.email}</td>
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
                <td>
                    <table>

                        <thead>
                            <tr><th>Materiaal</th><th>Aantal</th></tr>
                        </thead>
                        
                        <c:forEach var="rl" items="${r.reservatielijnen}">
                            <tr><td>${rl.materiaal.naam}</td><td>${rl.aantal}</td></tr>
                        </c:forEach>
                        
                    </table>
                </c:forEach></td>
        </tr>
    </table>
</div>

<jsp:include page="partials/footer.jsp" />
