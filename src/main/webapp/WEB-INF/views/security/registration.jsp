<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<spring:message code="label_user_reg" var="userReg"/>
<spring:message code="label_login" var="labelLogin"/>
<spring:message code="label_password" var="labelPass"/>
<spring:message code="label_email" var="labelAuthorEmail"/>
<spring:message code="label_first_name" var="labelFirstName"/>
<spring:message code="label_last_name" var="labelLastName"/>
<spring:message code="button_save" var="buttonSave"/>

<c:set value="${pageContext.request.contextPath}" var="contextPath"/>

<section class="container">
    <div class="login">
        <h2>${userReg}</h2>

        <c:if test="${not empty message}">
            <p><span class="error">${message}</span></p>
        </c:if>

        <form:form modelAttribute="user" action="${contextPath}/registration" method='POST'>

            <p><form:input path="firstname" value="" placeholder="${labelFirstName}"/>
                <form:errors path="firstname" cssClass="error"/>
            </p>

            <p><form:input path="lastname" value="" placeholder="${labelLastName}"/>
                <form:errors path="lastname" cssClass="error"/>
            </p>

            <p><form:input path="email" value="" placeholder="${labelAuthorEmail}"/>
                <form:errors path="email" cssClass="error"/>
            </p>

            <p><form:input path="login" type="text" placeholder="${labelLogin}"/>
                <form:errors path="login" cssClass="error"/>
            </p>

            <p><form:input path="password" type="password" placeholder="${labelPass}"/>
                <form:errors path="password" cssClass="error"/>
            </p>

            <p class="submit"><input type="submit" name="commit" value="${buttonSave}"/></p>
        </form:form>
    </div>
</section>