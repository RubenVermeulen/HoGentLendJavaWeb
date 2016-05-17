<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="partials/header.jsp">
    <jsp:param name="title" value="Reservaties"/>
</jsp:include>

<a href="../filter" class="gaterugknop btn btn-primary">Ga terug naar lijst kiezen</a>

<h1>Reservaties</h1>

<c:choose>
    <c:when test="${isEmptyReservaties == true}">
        <p>Er zijn geen reservaties voor de gekozen datum.</p>
    </c:when>    
    <c:otherwise>
        <c:forEach var="r" items="${reservaties}">
            <div class="row list">

                <!-- Basic information -->
                <div class="col-md-5 list-items">
                    <div class="col-md-12 detail">
                        <strong>Gebruiker</strong><br>
                        <a href="mailto:${r.lener.email}">${r.lener.email}</a>
                    </div>
                    <div class="col-md-12 detail">
                        <strong>Periode</strong><br>
                        <fmt:formatDate pattern="dd-MM-yyyy" value="${r.ophaalmoment}" /> tot <fmt:formatDate pattern="dd-MM-yyyy" value="${r.indienmoment}" />
                    </div>
                    <div class="col-md-12 detail">
                        <strong>Gereserveerd op</strong><br>
                        <fmt:formatDate pattern="dd-MM-yyyy" value="${r.reservatiemoment}" />
                    </div>
                    <div class="col-md-12 detail">
                        <strong>Status</strong><br>
                        <c:choose>
                            <c:when test="${r.opgehaald == true}">
                                <span class="tag tag-success">Opgehaald</span>
                            </c:when>    
                            <c:otherwise>
                                <span class="tag tag-warning">Niet opgehaald</span>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>

                <!-- Materials  -->
                <div class="col-md-7">
                    <div class="row" style="margin: 0">
                        <!-- header -->
                        <div class="col-md-6 col-xs-7">
                            <strong>Materiaal</strong><br>
                        </div>
                        <div class="col-md-6 col-xs-5">
                            <strong>Aantal stuks</strong><br>
                        </div>
                        <!-- /header -->

                    </div>

                    <hr style="margin: 8px 0">

                    <c:forEach var="rl" items="${r.reservatielijnen}">
                        <div class="row" style="margin: 0;">
                            <div class="col-md-6 col-xs-7">
                                ${rl.materiaal.naam}
                            </div>
                            <div class="col-md-6 col-xs-5">
                                ${rl.aantal}
                            </div>
                        </div>

                        <hr style="margin: 8px 0">
                    </c:forEach>
                </div>
            </div>
        </c:forEach>
    </c:otherwise>
</c:choose>

<jsp:include page="partials/footer.jsp" />
