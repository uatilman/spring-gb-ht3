<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page session="true" %>

<div class="padding-site">
    <div class="login">
        <h2>Авторизация</h2>
        <form action="<c:url value='/login' />" method="post">
            <c:if test="${not empty message}">
                <span class="error">${message}</span>
            </c:if>
            <p><input type="text" name="login" value="admin" placeholder="Логин"></p>
            <p><input type="password" name="password" value="admin@123" placeholder="Пароль"></p>
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
            <input class="login-button" type="submit" name="commit" value="Войти">
        </form>
    </div>
</div>

