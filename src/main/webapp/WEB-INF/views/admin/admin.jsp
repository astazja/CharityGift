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
<header>
    <c:import url="../header.jsp"/>
</header>
<section>
    <div class="login-page">
        <div class="slogan--item">
            <h2>Panel administracyjny:</h2>
            <br>
            <div class="form-group">
                <a href="<c:url value="/admin/institutions"/>" class="btn btn--without-border">Zarządzanie Instytucjami</a>
                <a href="<c:url value="/admin/admins"/>" class="btn btn--without-border">Zarządzanie Administratorami</a>
                <a href="<c:url value="/admin/users"/>" class="btn btn--without-border">Zarządzanie Użytkownikami</a>
            </div>
        </div>
    </div>
</section>


<c:import url="../footer.jsp"/>

<script src="<c:url value="../resources/js/app.js"/>"></script>
</body>
</html>
