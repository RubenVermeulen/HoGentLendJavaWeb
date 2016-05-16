<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-md-4">
    <c:if test="${not empty datumError}">
        <div class="alert alert-warning">${datumError}</div>
    </c:if>
      <form:form method="POST" action="filter" modelAttribute="filterData">
        <div class="radio">
            <label>
                <form:radiobutton path="soortLijst" value="uitgeleende"/> Uitgeleende materialen
            </label>
        </div>
        <div class="radio">
            <label>
                <form:radiobutton path="soortLijst" value="gereserveerde"/> Gereserveerde materialen
            </label>
        </div>
        <div class="form-group">
            <label>Vanaf: (optioneel)</label>
            <form:input path="datum" class="form-control" type="date"/>
        </div>
        <input class="btn btn-default" type="submit" value="Geef lijst"/>
    </form:form>
</div>