<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
</head>
<body>
<header>
    <c:import url="../header.jsp"/>
</header>
<section>
    <div class="login-page">
        <div class="slogan--item">
            <h2>Lista Użytkowników:</h2>
            <div>
                <table border="1">
                    <thead>
                    <tr>
                        <th>Imię</th>
                        <th>Nazwisko</th>
                        <th>Email</th>
                        <th colspan="3">Akcje</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td>${user.email}</td>
                            <td><a href="<c:url value="/admin/editUser/${user.id}"/>">Edycja</a></td>
                            <c:if test="${user.enable == 1}">
                                <td><a href="<c:url value="/admin/disableUser/${user.id}"/>">Zablokuj</a></td>
                            </c:if>
                            <c:if test="${user.enable == 0}">
                                <td><a href="<c:url value="/admin/enableUser/${user.id}"/>">Odblokuj</a></td>
                            </c:if>
                            <td><a href="<c:url value="/admin/deleteUser/${user.id}"/>">Usuń</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="form-group">
                <a href="<c:url value="/admin/addUser"/>" class="btn btn--without-border">Dodaj Użytkownika</a>
                <a href="<c:url value="/admin"/>" class="btn btn--without-border">Powrót do panelu administracyjnego</a>
            </div>
        </div>
    </div>
</section>


<c:import url="../footer.jsp"/>

<script src="<c:url value="../resources/js/app.js"/>"></script>
</body>
</html>
