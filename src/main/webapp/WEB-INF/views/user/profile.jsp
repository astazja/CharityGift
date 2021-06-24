<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h2>Twoje dane:</h2>
            <div class="slogan--steps-title">
                <label class="small mb-1" for="firstName">Imię:</label>
                <div class="form-control" id="firstName">
                    <c:out value="${user.firstName}"/>
                </div>
            </div>
            <div class="slogan--steps-title">
                <label class="small mb-1" for="lastName">Nazwisko:</label>
                <div class="form-control" id="lastName">
                    <c:out value="${user.lastName}"/>
                </div>
            </div>
            <div class="slogan--steps-title">
                <label class="small mb-1" for="email">Email:</label>
                <div class="form-control" id="email">
                    <c:out value="${user.email}"/>
                </div>
            </div>
            <br>
            <div class="slogan--steps-title">
                <a href="#" class="btn">Zmień dane</a>
                <a href="#" class="btn">Zmień hasło</a>
            </div>
        </div>
    </div>
</header>

<c:import url="../footer.jsp"/>

<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>
