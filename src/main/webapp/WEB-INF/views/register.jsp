<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta http-equiv="X-UA-Compatible" content="ie=edge" />
  <title>Document</title>
  <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>" />
</head>
<body>

<header>
  <c:import url="header.jsp"/>
</header>

<section class="login-page">
  <h2>Załóż konto</h2>
  <form:form modelAttribute="user">
    <div class="form-group">
      <form:input path="firstName" placeholder="Imię"/>
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
    <div class="form-group">
      <input type="password" name="repeat" placeholder="Powtórz hasło"/>
      <p><c:out value="${repeatMessage}"/></p>
    </div>

    <div class="form-group form-group--buttons">
      <a href="<c:url value="/login"/>" class="btn btn--without-border">Zaloguj się</a>
      <button class="btn" type="submit">Załóż konto</button>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  </form:form>
</section>

<c:import url="footer.jsp"/>
</body>
</html>

