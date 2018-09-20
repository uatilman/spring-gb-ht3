<%@ page session="true" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:message code="menu_chambers_list" var="labelMenuChamberList"/>
<spring:message code="menu_add_chamber" var="labelMenuAddChamber"/>
<spring:message code="menu_other" var="labelMenuOther"/>


<script>
    var contextPath = "${pageContext.request.contextPath}";
    $(document).ready(
        function () {
            var currentLang = "${pageContext.response.locale}";
            var data = (currentLang === "ru") ? "en" : "ru";
            var langImgSrc = "${pageContext.request.contextPath}/resources/img/" + currentLang + ".png";
            $(document).find(".lang-icon").attr("src", langImgSrc);

            $(".lang-icon").click(function () {
                $.ajax({
                    url: contextPath,
                    type: 'GET',
                    data: {
                        lang: data
                    },
                    cache: false,
                    success: function () {
                        location.reload();
                    }
                });
            });
        }
    );
</script>

<header class="padding-site">
    <div class="header">
        <nav>
            <ul class="menu">
                <li><a href="${pageContext.request.contextPath}/chambers">${labelMenuChamberList}</a></li>
                <li><a href="${pageContext.request.contextPath}/chambers/add?form">${labelMenuAddChamber}</a></li>
                <li><a href="#">${labelMenuOther}</a></li>
                <li><a href="#">${labelMenuOther}</a></li>

                <sec:authorize access="isAnonymous()">
                    <li><a href="${pageContext.request.contextPath}/registration">Registration</a></li>
                    <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <li><a href="${pageContext.request.contextPath}/logout"><b>${pageContext.request.userPrincipal.name}</b>(Logout)</a></li>
                </sec:authorize>
                <li><img class="lang-icon" src='' alt="lang"></li>
            </ul>
        </nav>
    </div>
</header>