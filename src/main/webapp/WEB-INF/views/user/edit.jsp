<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="../resources/css/style.css"/>" />
</head>
<body>
<header class="header--form-page">
    <c:import url="../header.jsp"/>
    <div class="slogan container container--90">
        <div class="slogan--item">
            <h2>Edytuj dane:</h2>
            <form:form modelAttribute="user" action="/user/edit" method="post">
                <form:hidden path="id"/>
                <form:hidden path="enable"/>
                <div class="slogan--steps-title">
                    <label class="small mb-1" for="firstName">Imię:</label>
                    <div class="form-control" id="firstName">
                        <form:input path="firstName" placeholder="Imię"/>
                        <form:errors path="firstName"/>
                    </div>
                </div>
                <div class="slogan--steps-title">
                    <label class="small mb-1" for="lastName">Nazwisko:</label>
                    <div class="form-control" id="lastName">
                        <form:input path="lastName" placeholder="Nazwisko"/>
                        <form:errors path="lastName"/>
                    </div>
                </div>
                <div class="slogan--steps-title">
                    <label class="small mb-1" for="password">Nowe hasło:</label>
                    <div class="form-control" id="password">
                        <input type="password" name="password" placeholder="Nowe hasło"/>
                    </div>
                </div>
                <div class="slogan--steps-title">
                    <label class="small mb-1" for="repeat">Powtórz nowe hasło:</label>
                    <div class="form-control" id="repeat">
                        <input type="password" name="repeat" placeholder="Powtórz hasło"/>
                    </div>
                </div>
                <div class="slogan--steps-title">
                    <button class="btn btn--without-border">
                        <a href="<c:url value="/user/profile"/>" >Anuluj</a>
                    </button>
                    <button class="btn" type="submit">Zmień dane</button>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form:form>
        </div>
    </div>
</header>

<c:import url="../footer.jsp"/>

<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>

