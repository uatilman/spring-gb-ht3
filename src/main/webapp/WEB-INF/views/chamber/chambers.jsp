<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<spring:message code="table_chamber_id" var="labelId"/>
<spring:message code="table_chamber_name" var="labelName"/>
<spring:message code="table_chamber_region" var="labelRegion"/>
<spring:message code="table_chamber_district" var="labelDistrict"/>
<spring:message code="table_chamber_action" var="labelAction"/>

<%--<html>--%>

<%--<jsp:include page="../fragments/head.jsp">
    <jsp:param name="title" value="Chambers"/>
</jsp:include>--%>

<%--
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Список палат</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script language="JavaScript" type="text/javascript">
        var contextPath = "${pageContext.request.contextPath}";
        var url = contextPath + "/chambers/articles_ajax";

    </script>
    <script language="JavaScript" type="text/javascript"
            src="${pageContext.request.contextPath}/resources/assets/getData.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>

<div class="container">--%>

<%--  <jsp:include page="../fragments/header.jsp"/>--%>

<%--<main class="content">--%>

<script language="JavaScript" type="text/javascript">
    var contextPath = "${pageContext.request.contextPath}";
    var url = contextPath + "/chambers/articles_ajax";
</script>
<script language="JavaScript" type="text/javascript"
        src="${pageContext.request.contextPath}/resources/assets/getData.js"></script>


<div class="padding-site">
    <h2 class="table-head">${message}</h2>
    <br>
    <table class="chamber-table">
        <thead>
        <tr>
            <th>Id</th>
            <th>${labelName}</th>
            <th>Region</th>
            <th>District</th>
            <th>Action</th>
        </tr>
        </thead>
    </table>

</div>
<%--</main>--%>

<%--
    <jsp:include page="../fragments/footer.jsp"/>
--%>
<%--

</body>
</html>--%>
