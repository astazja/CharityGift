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
                        <th>Status</th>
                        <th>Data stworzenia</th>
                        <th>Data przekazania</th>
                        <th>Godzina przekazania</th>
                        <th>Instytucja</th>
                        <th>Przekazano</th>
                        <th>Ilość przekazanych worków</th>
                        <th colspan="4">Dane adresowe</th>
                        <th>Komentarz dla kuriera</th>
                        <th colspan="3">Akcja</th>
                    </tr>
                    </thead>
                    <tbody>

                        <tr>
                            <td>
                                <c:if test="${donation.status.status==1}">Odebrano</c:if>
                                <c:if test="${donation.status.status==0}">Nie odebrano</c:if>
                            </td>
                            <td>${donation.date}</td>
                            <td>${donation.pickUpDate}</td>
                            <td>${donation.pickUpTime}</td>
                            <td>Fundacja: "${donation.institution.name}"</td>
                            <td>
                                <c:forEach items="${donation.categories}" var="category">
                                    <ul>
                                        <li>${category.name}</li>
                                    </ul>
                                </c:forEach>
                            </td>
                            <td>${donation.quantity}</td>
                            <td colspan="4">
                                <ul>
                                    <li>Miasto: ${donation.city}</li>
                                    <li>Ulica: ${donation.street}</li>
                                    <li>Kod pocztowy: ${donation.zipCode}</li>
                                </ul>
                            </td>
                            <td>${donation.pickUpComment}</td>
                            <td>
                                <c:if test="${donation.status.status==0}">
                                    <a class="btn btn--small btn--highlighted" href="<c:url value="/user/donation/status/${donation.id}"/>">Zmień status na odebrane</a>
                                </c:if>
                                <button class="btn btn--without-border">
                                    <a href="<c:url value="/user/donation"/>">Powrót</a>
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
