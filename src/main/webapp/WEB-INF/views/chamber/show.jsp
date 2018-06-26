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

<spring:message code="button_edit" var="labelButtonEdit"/>
<spring:message code="button_remove" var="labelButtonRemove"/>


<div class="padding-site">
    <h2>${chamber.name}</h2>
    <br>
    <br>
    <p><strong>${labelId}:</strong> ${chamber.id}</p>
    <p><strong>${labelRegion}:</strong> ${chamber.region.name}</p>
    <p><strong>${labelDistrict}:</strong> ${chamber.region.district.name}</p>
    <p><strong>${labelAddress}:</strong> ${chamber.address}</p>

    <div class="button-panel">
        <a href="${pageContext.request.contextPath}/chambers/remove/${chamber.id}"
           class="order-button">${labelButtonRemove}</a>
        <a href="${pageContext.request.contextPath}/chambers/${chamber.id}/?form"
           class="order-button">${labelButtonEdit}</a><br>
    </div>

</div>
