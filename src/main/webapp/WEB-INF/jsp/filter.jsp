<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="partials/header.jsp">
    <jsp:param name="title" value="Reservaties"/>
</jsp:include>

<h1>Zoek lijsten</h1>

<jsp:include page="partials/filter.jsp"/>

<jsp:include page="partials/footer.jsp" />
