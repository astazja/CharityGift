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
<header class="header--form-page">
    <c:import url="../header.jsp"/>
    <div class="slogan container container--90">
        <div class="slogan--item">
            <h2>Twoje zbiórki:</h2>
            <div class="slogan--steps-title">
                <table class="donations">
                    <thead>
                    <tr>
                        <th>Data utworzenia</th>
                        <th>Status</th>
                        <th>Data przekazania</th>
                        <th>Organizacja</th>
                        <th>Ilość przekazanych worków</th>
                        <th colspan="3">Akcja</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${donations}" var="donation">
                        <tr>
                            <td>${donation.created}</td>
                            <td>${donation.status}</td>
                            <td>${donation.pickUpDate}</td>
                            <td>Fundacja: "${donation.institution.name}"</td>
                            <td>${donation.quantity} worki 60 litrowe</td>
                            <td>
                                <button class="btn">
                                    <a href="#">Szczegóły</a>
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td>2021-02-09</td>
                        <td>Odebrano</td>
                        <td>2021-02-09</td>
                        <td>Fundacja: "A kogo"</td>
                        <td>2 worki 60 litrowe</td>
                        <td>
                            <button class="btn">
                                <a href="#">Szczegóły</a>
                            </button>
                        </td>
                    </tr>
                    <tr>
                        <td>2021-02-09</td>
                        <td>Odebrano</td>
                        <td>2021-02-09</td>
                        <td>Fundacja: "A kogo"</td>
                        <td>2 worki 60 litrowe</td>
                        <td>
                            <button class="btn">
                                <a href="#">Szczegóły</a>
                            </button>
                        </td>
                    </tr>
                    <tr>
                        <td>2021-02-09</td>
                        <td>Odebrano</td>
                        <td>2021-02-09</td>
                        <td>Fundacja: "A kogo"</td>
                        <td>2 worki 60 litrowe</td>
                        <td>
                            <button class="btn">
                                <a href="#">Szczegóły</a>
                            </button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</header>


<c:import url="../footer.jsp"/>

<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>
