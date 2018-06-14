<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" errorPage="chambers.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Список палат</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<div id="templatemo_content"></div>
<button class="btn_load">Загрузить еще</button>

<script>
    var url = "./chambers/articles_ajax";
    var contextPath = "${pageContext.request.contextPath}";
</script>
<script src="${pageContext.request.contextPath}/resources/assets/getData.js"></script>

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
                                <td class="description-column">${chamber.regions.name}</td>
                                <td class="description-column">${chamber.regions.districs.name}</td>
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