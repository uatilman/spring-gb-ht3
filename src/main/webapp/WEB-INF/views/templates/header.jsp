<%@ page session="false" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script>
    $(document).ready(
        function () {
            var currentLang = "${pageContext.response.locale}";
            var data = (currentLang === "ru") ? "en" : "ru";
            $(document).find(".lang").html(data);

            $(".lang").click(function () {
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
    <%--<div class="lang"><a href="${pageContext.request.servletPath}?lang=ru"></a></div>--%>
    <div class="header">
        <nav>
            <div class="lang"></div>
            <ul class="menu">
                <li><a href="${pageContext.request.contextPath}/chambers">Chambers list</a></li>
                <li><a href="${pageContext.request.contextPath}/chambers?form">Add chamber</a></li>
                <li><a href="#">Page 3</a></li>
                <li><a href="#">Page 4</a></li>
                </li>
            </ul>
        </nav>
    </div>
</header>