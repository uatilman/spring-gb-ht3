<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page session="false" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" errorPage="chambers.jsp" %>

<html>
<head>
    <title>Add new company</title>
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


            <h3>Add company</h3>
            <form:form modelAttribute="chamber" method="post">

                <table border="1">
                    <tr>
                        <td><form:label path="name">Chamber name</form:label></td>
                        <td><form:input path="name"/></td>
                    </tr>

                    <tr>
                        <td><form:label path="region">Region</form:label></td>
                        <td>
                            <select name="regionId">
                                <c:if test="${not empty regions}">
                                    <option value="0" selected>Выберите регион</option>
                                    <c:forEach items="${regions}" var="region">
                                        <option value="${region.id}">${region.name}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td><form:label path="address">Chamber address</form:label></td>
                        <td><form:textarea path="address" id="content" class="contentarea"/></td>
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