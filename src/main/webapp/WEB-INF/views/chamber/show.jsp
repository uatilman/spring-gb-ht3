<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<spring:message code="table_chamber_id" var="labelId"/>
<spring:message code="table_chamber_name" var="labelName"/>
<spring:message code="table_chamber_region" var="labelRegion"/>
<spring:message code="table_chamber_district" var="labelDistrict"/>
<spring:message code="table_chamber_address" var="labelAddress"/>
<spring:message code="table_chamber_action" var="labelAction"/>

<html>

<jsp:include page="../fragments/head.jsp">
    <jsp:param name="title" value="Chambers"/>
</jsp:include>


<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Список палат</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script language="JavaScript" type="text/javascript">
        var url = "chambers/articles_ajax";
        var contextPath = "${pageContext.request.contextPath}";
    </script>
    <script language="JavaScript" type="text/javascript"
            src="${pageContext.request.contextPath}/resources/assets/getData.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>

<div class="container">

    <jsp:include page="../fragments/header.jsp"/>

    <main class="content">
        <div class="padding-site">
            <h2>${chamber.name}</h2>
            <br>
            <br>
            <p><strong>${labelId}:</strong> ${chamber.id}</p>
            <p><strong>${labelRegion}:</strong> ${chamber.region.name}</p>
            <p><strong>${labelDistrict}:</strong> ${chamber.region.district.name}</p>
            <p><strong>${labelAddress}:</strong> ${chamber.address}</p>
        </div>
    </main>

    <jsp:include page="../fragments/footer.jsp"/>

</body>
</html>