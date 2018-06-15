<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" errorPage="chambers.jsp" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Список палат</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>


<script>
    var url = "chambers/articles_ajax";
    var contextPath = "${pageContext.request.contextPath}";
</script>
<script src="${pageContext.request.contextPath}/resources/assets/getData.js"></script>


<div class="container">
    <div class="padding-site">
        <div class="product-table">
            <h2>${message}</h2>

            <br>

            <table border="1" id="chamber-table">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Region</th>
                    <th>District</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>


</body>
</html>