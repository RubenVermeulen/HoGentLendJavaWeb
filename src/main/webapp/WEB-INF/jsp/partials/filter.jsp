<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="filter">
    <c:if test="${not empty datumError}">
        <div class="alert alert-warning">${datumError}</div>
    </c:if>
    <form:form method="POST" action="filter" modelAttribute="filterData" class="form-horizontal">
        <div class="form-group">
            <div class="row" style="margin: 0;">
                <div class="col-md-6">
                    <label>
                    <form:radiobutton path="soortLijst" value="uitgeleende"/> Uitgeleende materialen
                </label>
                </div>
                <div class="col-md-6">
                     <label>
                    <form:radiobutton path="soortLijst" value="gereserveerde"/> Gereserveerde materialen
                </label>
                </div>
                <br><br>   
            </div>
            <div class="col-md-12">
                <label for="date">Vanaf: (optioneel)</label>
                <form:input path="datum" class="form-control" type="date" id="type"/>
            </div>
            <div class="col-md-12">
                <div class="row">
                    <div class="col-sm-12">
                        <input class="btn btn-primary form-control" type="submit" value="Geef lijst"/>
                    </div>
                </div>
            </div>
        </div>
    </form:form>
</div>