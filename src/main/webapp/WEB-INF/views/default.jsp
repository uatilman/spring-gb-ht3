<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>
        <c:choose>
            <c:when test="${not empty title}">${title}</c:when>
            <c:otherwise><tiles:insertAttribute name="title" ignore="true"/></c:otherwise>
        </c:choose>
    </title>
    <script src="https://code.jquery.com/jquery-3.1.1.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/ckeditor/ckeditor.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<tiles:insertAttribute name="head" ignore="true"/>

<body>
<tiles:insertAttribute name="scripParameters" ignore="true"/>

<div class="container">
    <tiles:insertAttribute name="header" ignore="true"/>
    <main class="content">
        <tiles:insertAttribute name="content" ignore="true"/>
    </main>
</div>
<tiles:insertAttribute name="footer" ignore="true"/>

</body>
</html>