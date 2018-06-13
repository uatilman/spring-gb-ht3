<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" errorPage="chambers.jsp"   %>
<html>
<head>
    <title>Список палат</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<div class="container">
    <div class="padding-site">
        <div class="product-table">

            <h2>${message}</h2>

            <c:choose>

                <c:when test="${not empty chambers}">
                    <table border="1">
                        <c:forEach items="${chambers}" var="chamber">
                            <tr>
                                <td class="name-column">${chamber.id}</td>
                                <td class="description-column">${chamber.name}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>

                <c:when test="${empty chambers}">
                    <p style="color: red">Информация не найдена</p>
                </c:when>

            </c:choose>
            <br>

        </div>
    </div>
</div>


</body>
</html>