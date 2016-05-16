<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "spring" uri="http://www.springframework.org/tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title><c:out value="${param.title}" /> - HoGent Lend</title>

        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <spring:url value="/css/stylesheet.css" var="urlCss"/>
        <link rel="stylesheet" href="${urlCss}" type="text/css"/>
       
        
    </head>
    <body>
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="#" class="navbar-brand">HoGent Lend</a>
                </div>
                <div class="navbar-collapse collapse">
                    <c:url var="logoutUrl" value="/logout"/>
                    <form action="${logoutUrl}" method="post">
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a><input type="submit" value="Uitloggen" class="test"/></a>
                            </li>
                        </ul>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>

                </div>


            </div>
        </div>

        <div class="container body-content">