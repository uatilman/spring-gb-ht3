<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<spring:message code="validation.name.size" var="nameErrorSize"/>

<html>
<head>
    <title>Add new chamber</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/ckeditor/ckeditor.js"></script>
</head>
<body>

<script type="text/javascript">
    $(document).ready(function () {
        CKEDITOR.replace('content');
        CKEDITOR.config.width = "50%";
        CKEDITOR.config.height = 300;
    });
</script>

<div class="container">
    <div class="padding-site">
        <div class="product-table">

            <h3>Add chamber</h3>
            <form:form modelAttribute="chamber" acceptCharset="UTF-8" method="post">

                <table>
                    <tr>
                        <td><form:label path="name">Chamber name</form:label></td>
                        <td><form:input path="name"/></td>
                        <td><form:errors path="name" cssClass="error"/></td>
                    </tr>

                    <tr>
                        <td><form:label path="region">Region</form:label></td>
                        <td><form:select path="region" items="${regions}" name="region1id" itemValue="id" itemLabel="name"/></td>
                        <td><form:errors path="region" cssClass="error"/></td>
                    </tr>

                    <tr>
                        <td><form:label path="address">Chamber address</form:label></td>
                        <td><form:textarea path="address" id="content" class="contentarea"/></td>
                        <td><form:errors path="address" cssClass="error"/></td>
                    </tr>
                </table>

                <br/>
                <button class="order-button" type="submit">Save</button>


            </form:form>
        </div>
    </div>
</div>

</body>
</html>