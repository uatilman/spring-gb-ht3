<%@ page session="true" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message code="table_chamber_id" var="labelId"/>
<spring:message code="table_chamber_name" var="labelName"/>
<spring:message code="table_chamber_region" var="labelRegion"/>
<spring:message code="table_chamber_district" var="labelDistrict"/>
<spring:message code="table_chamber_action" var="labelAction"/>


<%--  <jsp:include page="../fragments/header.jsp"/>--%>

<script language="JavaScript" type="text/javascript">
    var url = contextPath + "/chambers/articles_ajax";
</script>
<script language="JavaScript" type="text/javascript"
        src="${pageContext.request.contextPath}/resources/assets/getData.js"></script>


<div class="padding-site">

<%--
    <c:forEach items="${indicators}" var="indicator">
        ${indicator.name}<br>
    </c:forEach>
--%>

    <h2 class="table-head">${chambersCount}</h2>
    <br>
    <table class="chamber-table">
        <thead>
        <tr>
            <th>${labelId}</th>
            <th>${labelName}</th>
            <th>${labelRegion}</th>
            <th>${labelDistrict}</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>

</div>

<%--<jsp:include page="../fragments/footer.jsp"/>--%>
