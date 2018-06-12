<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Companies</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<div class="container">
    <div class="padding-site">
        <div class="product-table">

            <h2>${message}</h2>

            <c:choose>

                <c:when test="${not empty companies}">
                    <table border="1">
                        <c:forEach items="${companies}" var="company">
                            <tr>
                                <td class="name-column">${company.name}</td>
                                <td class="description-column">${company.description}</td>
                                <td class="description-column">${company.address}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>

                <c:when test="${empty companies}">
                    <p style="color: red">Information not found</p>
                </c:when>

            </c:choose>
            <br>
            <a href="${pageContext.request.contextPath}/add" class="order-button">Add company</a>

        </div>
    </div>
</div>


</body>
</html>