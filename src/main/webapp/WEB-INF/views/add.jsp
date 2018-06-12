<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Add new company</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<h3>Add company</h3>
<form:form modelAttribute="company" method="post">

    <table border="1">
        <tr>
            <td><form:label path="name">Company name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>

        <tr>
            <td><form:label path="description">Description</form:label></td>
            <td><form:input path="description"/></td>
        </tr>

        <tr>
            <td><form:label path="address">Company address</form:label></td>
            <td><form:input path="address"/></td>
        </tr>
    </table>

    <br/>
    <button class="order-button" type="submit">Save</button>

</form:form>

</body>
</html>