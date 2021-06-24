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
            <a href="#" class="btn btn--large">Podaruj rzeczy</a>
            <h2>Twoje zbiórki:</h2>
            <div class="slogan--steps-title">
                Tabela ze zbiórkami i akcje obok
            </div>
            <br>
            <div class="slogan--steps-title">
                <a href="#" class="btn">Szczegóły</a>
                <a href="#" class="btn">Edytuj</a>
                <a href="#" class="btn">Usuń</a>
            </div>
        </div>
    </div>
</header>


<c:import url="../footer.jsp"/>

<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>
