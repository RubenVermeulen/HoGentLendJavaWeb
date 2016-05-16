

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Inloggen - HoGent Lend</title>

        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <spring:url value="/css/stylesheet.css" var="urlCss"/>
        <spring:url value="/img/login-bg.jpg" var="loginbg"/>
        <spring:url value="/img/logo.png" var="logo"/>
        
        <link rel="stylesheet" href="${urlCss}" type="text/css" />
    </head>

    <body id="login">

        <div class="row">
            <div class="col-md-8 col-sm-5 hidden-xs branding"></div>
            <div class="col-md-4 col-sm-5 col-md-offset-8 col-sm-offset-5 login-aside">
                <form name='loginForm' action="<c:url value='/login' />" method='POST'>
                    <img src="${logo}" alt="HoGent Logo"/>

                    <h2 class="hogent-lend-brand">HoGent Lend - Admin</h2>


                    <c:if test="${not empty error}">
                        <div class="alert alert-danger">${error}</div>
                    </c:if>
                        
                    <h5>Typ uw e-mailadres en wachtwoord</h5>

                    <!--@Html.ValidationSummary(true, "", new {@class = "text-danger"})-->
                    <div class="form-group">
                        <label class="col-md-12" for="username" value="">Gebruikersnaam</label>
                        <div class="col-md-10">
                            <input class="form-control" id="username" name="username" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-12" for="password">Wachtwoord</label>
                        <div class="col-md-10">
                            <input class="form-control" id="password" name="password" type="password">
                            <!--@Html.PasswordFor(m => m.Password, new {@class = "form-control"})
                            @Html.ValidationMessageFor(m => m.Password, "", new {@class = "text-danger"})-->
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="submit" value="Log in" class="btn btn-primary" name="submit"/>
                        </div>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}" />
                </form>
            </div>
        </div>

    </body>
</html>