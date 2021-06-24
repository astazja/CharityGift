<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="container container--70">
  <ul class="nav--actions">
    <sec:authorize access="!isAuthenticated()">
    <li><a href="<c:url value="/login"/>" class="btn btn--small btn--without-border">Zaloguj</a></li>
    <li><a href="<c:url value="/register"/>" class="btn btn--small btn--highlighted">Załóż konto</a></li>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
      <li class="logged-user">
        Witaj <c:out value="${user.firstName}"/>
        <ul class="dropdown">
          <li><a href="<c:url value="/user/profile"/>">Profil</a></li>
          <li><a href="<c:url value="/user/donation"/>">Moje zbiórki</a></li>
          <li>
            <form action="<c:url value="/logout"/>" method="post">
              <input type="submit" value="Wyloguj">
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
          </li>
        </ul>
      </li>
    </sec:authorize>
  </ul>

  <ul>
    <li><a href="<c:url value="/"/>" class="btn btn--without-border active">Start</a></li>
    <li><a href="<c:url value="/"/>#steps" class="btn btn--without-border">O co chodzi?</a></li>
    <li><a href="<c:url value="/"/>#about-us" class="btn btn--without-border">O nas</a></li>
    <li><a href="<c:url value="/"/>#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
    <li><a href="<c:url value="/"/>#contact" class="btn btn--without-border">Kontakt</a></li>
  </ul>
</nav>