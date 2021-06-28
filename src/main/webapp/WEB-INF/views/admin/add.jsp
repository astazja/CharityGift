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
<header>
    <c:import url="../header.jsp"/>
</header>
<section>
    <div class="login-page">
        <div class="slogan--item">
            <h2>Tworzenie Instytucji:</h2>
            <div>
                <form:form modelAttribute="admin" method="post">
                    <form:hidden path="id"/>
                    <div class="form-group">
                        <form:input path="firstName" placeholder="Imię administratora"/>
                        <form:errors path="firstName"/>
                    </div>
                    <div class="form-group">
                        <form:input path="lastName" placeholder="Nazwisko"/>
                        <form:errors path="lastName"/>
                    </div>
                    <div class="form-group">
                        <form:input type="email" path="email" placeholder="Email"/>
                        <form:errors path="email"/>
                        <p><c:out value="${emailMessage}"/></p>
                    </div>
                    <div class="form-group">
                        <form:input type="password" path="password" placeholder="Hasło"/>
                        <form:errors path="password"/>
                    </div>
                    <div class="form-group form-group--buttons">
                        <a href="<c:url value="/admin/admins"/>" class="btn btn--without-border">Anuluj</a>
                        <button class="btn" type="submit">Dodaj Administratora</button>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form:form>
            </div>
        </div>
    </div>
</section>


<c:import url="../footer.jsp"/>

<script src="<c:url value="../resources/js/app.js"/>"></script>
</body>
</html>
