<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<spring:message code="validation.name.size" var="nameErrorSize"/>

<spring:message code="table_chamber_name" var="labelName"/>
<spring:message code="table_chamber_region" var="labelRegion"/>
<spring:message code="table_chamber_district" var="labelDistrict"/>
<spring:message code="button_save" var="labelButtonSave"/>

<spring:message code="menu_add_chamber" var="labelMenuAddChamber"/>

<script type="text/javascript">
    $(document).ready(function () {
        CKEDITOR.replace('content');
        CKEDITOR.config.width = "50%";
        CKEDITOR.config.height = 300;
    });
</script>

<div class="padding-site">
    <div class="product-table">

        <h3>${title}</h3>
        <form:form modelAttribute="chamber" acceptCharset="UTF-8" method="post">

            <table>
                <tr>
                    <td><form:label path="name">${labelName}</form:label></td>
                    <td><form:input path="name"/></td>
                    <td><form:errors path="name" cssClass="error"/></td>
                </tr>

                <tr>
                    <td><form:label path="region">${labelRegion}</form:label></td>
                    <td><form:select path="region" items="${regions}" name="region1id" itemValue="id"
                                     itemLabel="name"/></td>
                    <td><form:errors path="region" cssClass="error"/></td>
                </tr>

                <tr>
                    <td><form:label path="address">${labelAddress}</form:label></td>
                    <td><form:textarea path="address" id="content" class="contentarea"/></td>
                    <td><form:errors path="address" cssClass="error"/></td>
                </tr>
            </table>

            <br/>
            <button class="order-button" type="submit">${labelButtonSave}</button>


        </form:form>
    </div>
</div>
