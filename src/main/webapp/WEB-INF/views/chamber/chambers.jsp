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


<%--  <jsp:include page="../fragments/header.jsp"/>--%>

<script language="JavaScript" type="text/javascript">
    var contextPath = "${pageContext.request.contextPath}";
    var url = contextPath + "/chambers/articles_ajax";
</script>
<script language="JavaScript" type="text/javascript"
        src="${pageContext.request.contextPath}/resources/assets/getData.js"></script>


<div class="padding-site">
    <h2 class="table-head">${chambersCount}</h2>
    <br>
    <table class="chamber-table">
        <thead>
        <tr>
            <th>Id</th>
            <th>${labelName}</th>
            <th>Region</th>
            <th>District</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>

</div>

<%--<jsp:include page="../fragments/footer.jsp"/>--%>
